package com.example.contestservice.service.impl;

import com.example.contestservice.dto.CategoryDTO;
import com.example.contestservice.dto.ContestDTO;
import com.example.contestservice.dto.QuestionsDTO;
import com.example.contestservice.entity.Contest;
import com.example.contestservice.entity.Questions;
import com.example.contestservice.entity.Ranking;
import com.example.contestservice.repository.ContestRepo;
import com.example.contestservice.repository.QuestionRepo;
import com.example.contestservice.repository.RankingRepo;
import com.example.contestservice.service.ContestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContestServiceImpl implements ContestService {

    @Autowired
    ContestRepo contestRepo;

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    RankingRepo rankingRepo;
    @Autowired
    QuestionRepo questionRepo;



    @Override
    public Contest addContest(Contest contest) {
        Contest contestData =  contestRepo.insert(contest);
        return contestData;
    }

    @Override
    public List<Contest> getAllContest() {
        List<Contest> allContest = contestRepo.findAll();
        List<Contest> approvedContest = new ArrayList <>();
        for(Contest contest: allContest)
        {
            if(contest.isApproved()){
                approvedContest.add(contest);
            }
        }
        return approvedContest;
    }

    @Override
    public Optional<Contest> getContestById(String userId) {
        return contestRepo.findById(userId);
    }


    @Override
    public String addRanking(Ranking ranking,String contestId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(contestId));
        Update update = new Update();
        update.addToSet("ranking", ranking);
        return "addedRanking";
    }

    @Override
    public List<Contest> getConstestByCategory(CategoryDTO categoryDTO) {
        List<Contest> contestList = new ArrayList<>();
        for(String i: categoryDTO.getUserCategory()){
          List<Contest >contest=   contestRepo.findBycontentCategory(i);
            contestList.addAll(contest);
        }
        return contestList;
    }

    @Override
    public List<Contest> getLeaderBoard(String constestId) {

        return null;

    }

    @Override
    public List <Contest> getAllContestByQuizMaster(String quizMasterId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("quizMasterId").is(quizMasterId));
        return mongoTemplate.find(query,Contest.class);

    }

    @Override
    public Boolean approveContest(String contestId) {
        if(contestRepo.existsById(contestId)){
            Optional<Contest> contestOptional = contestRepo.findById(contestId);
            Contest contest= contestOptional.get();
            contest.setApproved(true);
            contestRepo.save(contest);
        }
        return true;
    }


}
