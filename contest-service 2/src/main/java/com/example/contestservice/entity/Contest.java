package com.example.contestservice.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = "Contest")
public class Contest {
    @Id
    private String contestId;
    private String contestName;
    private String contentCategory;
    private Integer noOfQuestions;
    private String quizMasterId;
    private String quizType;
    private Long startTime;
    private Long endTime;
    private Long durationOfContest;
    private boolean isApproved;
    private String moderatorId;
    private List<Ranking> rankings;
}
