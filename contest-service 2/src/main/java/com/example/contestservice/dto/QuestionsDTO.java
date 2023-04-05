package com.example.contestservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionsDTO {
    private String questionId;
    private String question;
    private String questionUrl;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private List<String> answer;
    private String typeOfQuestion;      //img,text,audio;
    private Integer marks;
    private String typeOfAnswer;     //single
    private String difficultyLevel;
}
