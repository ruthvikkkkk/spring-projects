package com.example.contestservice.dto;


import com.example.contestservice.entity.Questions;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@ToString
public class ContestDTO {

    private String contestId;
    private String contestName;
    private String contentCategory;
    private Integer noOfQuestions;
    private String quizMasterId;
    private String quizType;
    private Long durationOfContest;
    private boolean isApproved;
    private String moderatorId;
    private Long startTime;
    private Long endTime;


}
