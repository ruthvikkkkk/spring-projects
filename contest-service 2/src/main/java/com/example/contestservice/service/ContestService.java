package com.example.contestservice.service;

import com.example.contestservice.dto.CategoryDTO;
import com.example.contestservice.dto.QuestionsDTO;
import com.example.contestservice.entity.Contest;
import com.example.contestservice.entity.Questions;
import com.example.contestservice.entity.Ranking;

import java.util.List;
import java.util.Optional;

public interface ContestService {

    public Contest addContest(Contest contest);
    public List<Contest> getAllContest();
    public Optional<Contest> getContestById(String id);
    public String addRanking(Ranking ranking, String contestId);
    public List<Contest> getConstestByCategory(CategoryDTO categoryDTO);
    public List<Contest> getLeaderBoard(String constestId);
    List<Contest> getAllContestByQuizMaster(String quizMasterId);
    Boolean approveContest(String contestId);
}