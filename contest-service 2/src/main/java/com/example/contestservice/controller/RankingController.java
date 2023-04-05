package com.example.contestservice.controller;


import com.example.contestservice.dto.RankingDTO;
import com.example.contestservice.dto.Status;
import com.example.contestservice.dto.UserScoreDTO;
import com.example.contestservice.entity.Ranking;
import com.example.contestservice.service.RankingService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ranking/")
public class RankingController {

    @Autowired
    RankingService rankingService;

    @PostMapping("getScoresOfUser")
    public ResponseEntity<String> getScoreOfUser(@RequestBody UserScoreDTO userScoreDTO){

        rankingService.saveuserScore(userScoreDTO);

        return new ResponseEntity("Thank you",HttpStatus.OK);
    }

    @GetMapping("getLeaderBoard/{contestId}")
    public ResponseEntity<Ranking> getLeaderBoard(@PathVariable("contestId") String contestId){

        return new ResponseEntity(rankingService.getLeaderBoardByContestId(contestId),HttpStatus.OK);
    }

    @GetMapping("/checkUserExistsOrNot/{userId}/{contestId}")
    public ResponseEntity<Boolean> checkUser(@PathVariable("userId") String userId, @PathVariable("contestId") String contestId){

        return new ResponseEntity <>(rankingService.checkUserStatus(userId,contestId),HttpStatus.OK);
    }
//    @GetMapping("getLeaderBoardByPage/{contestId}")
//    public ResponseEntity<RankingDTO> getLeaderBoardByPage(@PathVariable("contestId") String contestId,
//                                                           @RequestParam(defaultValue = "0") Integer pageNo,
//                                                           @RequestParam(defaultValue = "3") Integer pagesize)
//    {
//
//        return new ResponseEntity(rankingService.getLeaderBoardPageByContestId(contestId,pageNo, pagesize),HttpStatus.OK);
//    }


}
