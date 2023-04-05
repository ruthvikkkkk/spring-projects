package com.example.contestservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionsDataDTO {

    private String contestId;
    private List<QuestionsDTO> questionsData;
}