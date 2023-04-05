package com.example.contestservice.controller;


import com.example.contestservice.FeignInterface.DynamicContestFeign;
import com.example.contestservice.dto.CategoryDTO;
import com.example.contestservice.dto.ContestDTO;
import com.example.contestservice.dto.QuestionsDTO;
import com.example.contestservice.dto.RankingDTO;
import com.example.contestservice.entity.Contest;
import com.example.contestservice.entity.Ranking;
import com.example.contestservice.repository.ContestRepo;
import com.example.contestservice.service.ContestService;
import com.example.contestservice.service.QuestionService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.tools.tree.BooleanExpression;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/contest")
public class ContestController {

    @Autowired
    ContestService contestService;

    @Autowired
    ContestRepo contestRepo;

    @Autowired
    QuestionService questionService;
    @Autowired
    DynamicContestFeign dynamicContestFeign;

    @GetMapping("/test")
    public String test()
    {
        return "SOMETHING";
    }

    @PostMapping("/addContest")
    public ResponseEntity<ContestDTO> addContest(@RequestBody ContestDTO contestDTO)
    {
        if(contestDTO.getQuizType().equals("static")){
        Contest contest = new Contest();
        contestDTO.setContestId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(contestDTO, contest);
        contestService.addContest(contest);
            return new ResponseEntity<>(contestDTO, HttpStatus.CREATED);
        }
        else if(contestDTO.getQuizType().equals("dynamic")) {
            return new ResponseEntity<ContestDTO>(dynamicContestFeign.addDynamicContest(contestDTO), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<ContestDTO>(contestDTO, HttpStatus.CREATED);
        }
    }

    @GetMapping("/getAllApprovedContest")
    public ResponseEntity<List<Contest>> getAllContest() {
        List<Contest> allContest = contestService.getAllContest();
        return new ResponseEntity<List<Contest>>(allContest, HttpStatus.CREATED);
    }

    @GetMapping("/getContestById/{id}")
    public ResponseEntity<ContestDTO> getContestById(@PathVariable("id") String id)
    {
        Optional<Contest> contest = contestService.getContestById(id);
        ContestDTO contestDTO = new ContestDTO();
        if(contest.isPresent())
        {
            BeanUtils.copyProperties(contest.get(),contestDTO);
            return new ResponseEntity(contestDTO, HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity("No such user data is found", HttpStatus.OK);
        }
    }

    @PostMapping("/addRanking/{contestId}")
    public ResponseEntity<String> addRanking(@RequestBody RankingDTO rankingDTO, @PathVariable("contestId") String constestId) {
        Ranking ranking = new Ranking();
        BeanUtils.copyProperties(rankingDTO,ranking);
        contestService.addRanking(ranking, constestId);
        return new ResponseEntity<String>("ranking is added to data base", HttpStatus.CREATED);
    }

    @PostMapping("/addQuestion/{contestId}")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionsDTO questionsDTO, @PathVariable("contestId") String contestId) {
        QuestionsDTO questions = new QuestionsDTO();
        questions.setQuestionId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(questionsDTO, questions);
        questionService.addQuestion(questions, contestId);
        return new ResponseEntity<>("Question is added", HttpStatus.CREATED);
    }
//
//    @GetMapping(value = "/getContestByCategory/{categoryName}")
//    public List<Contest> getContestByCategory(@PathVariable("categoryName") String categoryName)
//    {
//        List<Contest> listOfCategory = contestService.getConstestByCategory(categoryName);
//        return listOfCategory;
//    }
    @PostMapping(value = "/getContestByCategory")
    public ResponseEntity<List<Contest>> getContestByCategoryhet(@RequestBody CategoryDTO categoryDTO)
    {
        List<Contest> contestDTOS = contestService.getConstestByCategory(categoryDTO);
        return new ResponseEntity(contestDTOS,HttpStatus.OK);
    }
    @GetMapping("getAllContestByQuizMaster/{quizMasterId}")
    public ResponseEntity<List<Contest>> getAllContestByQuizMaster(@PathVariable("quizMasterId") String quizMasterId){

        return new ResponseEntity(contestService.getAllContestByQuizMaster(quizMasterId),HttpStatus.OK);
    }
    @PostMapping(value = "/approveContest/{contestId}")
    public ResponseEntity<Boolean> approveContest(@PathVariable("contestId") String contestId)
    {
        Boolean bool = contestService.approveContest(contestId);
        return new ResponseEntity(bool,HttpStatus.OK);
    }



}
