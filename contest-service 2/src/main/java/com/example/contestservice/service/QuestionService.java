package com.example.contestservice.service;

import com.example.contestservice.dto.QuestionsDTO;
import com.example.contestservice.entity.Questions;
import java.util.Optional;

public interface QuestionService {
    public Optional<Questions> getContestById(String constestId);
    public String addQuestion(QuestionsDTO questionsDTO, String questionId);
    Integer incrementIndex(String contestId);
}