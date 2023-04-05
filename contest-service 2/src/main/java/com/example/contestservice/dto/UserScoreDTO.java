package com.example.contestservice.dto;

import lombok.Data;

@Data
public class UserScoreDTO {

    private String userId;
    private String contestId;
    private Integer score;
    private long timing;
}
