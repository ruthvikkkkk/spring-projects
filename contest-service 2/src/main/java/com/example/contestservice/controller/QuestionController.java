package com.example.contestservice.controller;

import com.example.contestservice.dto.ContestDTO;
import com.example.contestservice.dto.QuestionsDTO;
import com.example.contestservice.dto.QuestionsDataDTO;
import com.example.contestservice.entity.Contest;
import com.example.contestservice.entity.Questions;
import com.example.contestservice.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("questions/")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("getContestById/{id}")
    public ResponseEntity<QuestionsDataDTO> getContestById(@PathVariable("id") String id)
    {
        Optional<Questions> contest = questionService.getContestById(id);
        QuestionsDataDTO questionsDataDTO = new QuestionsDataDTO();
        if(contest.isPresent())
        {
            BeanUtils.copyProperties(contest.get(),questionsDataDTO);
            return new ResponseEntity(questionsDataDTO, HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity("No such user data is found", HttpStatus.OK);
        }
    }
    @GetMapping("incrementIndex/{contestId}")
    public ResponseEntity<Integer> incrementIndex(@PathVariable("contestId") String contestId){

        return new ResponseEntity(questionService.incrementIndex(contestId),HttpStatus.OK);
    }
}
