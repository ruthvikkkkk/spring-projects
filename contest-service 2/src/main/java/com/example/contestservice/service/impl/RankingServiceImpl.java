package com.example.contestservice.service.impl;

import com.example.contestservice.dto.RankingDTO;
import com.example.contestservice.dto.UserScoreDTO;
import com.example.contestservice.entity.Ranking;
import com.example.contestservice.repository.RankingRepo;
import com.example.contestservice.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class RankingServiceImpl implements RankingService {


    @Autowired
    RankingRepo rankingRepo;
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Ranking getLeaderBoardByContestId(String contestId){
        List<Ranking> rankingList = new ArrayList <>();
        List<RankingDTO> rankingDTOList = new ArrayList <>();
        Optional<Ranking> rankingOptional = rankingRepo.findById(contestId);
        if(rankingOptional.isPresent()){
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(contestId));
            rankingList.addAll(mongoTemplate.find(query,Ranking.class));
            rankingDTOList.addAll(rankingList.get(0).getUsersList());
            Collections.sort(rankingDTOList, new Comparator<RankingDTO>() {
                @Override
                public int compare(RankingDTO o2, RankingDTO o1){
                    if(o1.getScore().compareTo(o2.getScore())==0){
                        if(o1.getTiming()>o2.getTiming()){
                            return -1;
                        }
                        return 1;
                    }

                    return o1.getScore().compareTo(o2.getScore());

                }

            });
            rankingList.get(0).setUsersList(rankingDTOList);
            return  rankingList.get(0);
        }
        return null;

    }

    @Override
    public void saveuserScore(UserScoreDTO userScoreDTO) {
        RankingDTO rankingDTO = new RankingDTO();
        rankingDTO.setScore(userScoreDTO.getScore());
        rankingDTO.setUserId(userScoreDTO.getUserId());
        rankingDTO.setTiming(userScoreDTO.getTiming());
        if(rankingRepo.existsById(userScoreDTO.getContestId())){
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(userScoreDTO.getContestId()));
            Update update = new Update();
            update.addToSet("usersList",rankingDTO);
            mongoTemplate.findAndModify(query,update,Ranking.class);
        }
        else{
            List<RankingDTO> rankingDTOList = new ArrayList <>();
            rankingDTOList.add(rankingDTO);
            Ranking ranking = new Ranking();
            ranking.setContestId(userScoreDTO.getContestId());
            ranking.setUsersList(rankingDTOList);
            rankingRepo.save(ranking);
        }
    }

    @Override
    public Boolean checkUserStatus(String userId, String contestId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(contestId).and("usersList.userId").is(userId));
        List<Ranking> rankingList = mongoTemplate.find(query,Ranking.class);
        if(rankingList!=null){
            if(rankingList.size()!=0){
                return true;
            }
        }
        return false;
    }

//    @Override
//    public List <RankingDTO> getLeaderBoardPageByContestId(String contestId, Integer pageNo, Integer pagesize) {
//        Pageable paging = PageRequest.of(pageNo,pagesize);
//        Page<RankingDTO> pagedResult = rankingRepo.findAll(paging);
//        if(pagedResult.hasContent()){
//            return pagedResult.getContent();
//        }
//        else
//            return new ArrayList <Ranking>();
//    }
}
