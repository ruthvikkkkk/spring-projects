package com.example.contestservice.service;

import com.example.contestservice.dto.RankingDTO;
import com.example.contestservice.dto.UserScoreDTO;
import com.example.contestservice.entity.Ranking;
import java.util.List;

public interface RankingService {
    Ranking getLeaderBoardByContestId(String contestId);
    void saveuserScore(UserScoreDTO userScoreDTO);
    Boolean checkUserStatus(String userId, String contestId);
}