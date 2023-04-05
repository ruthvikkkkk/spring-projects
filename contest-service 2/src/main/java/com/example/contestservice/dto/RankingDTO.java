package com.example.contestservice.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RankingDTO {

    private String userId;
    private Integer score;
    private long timing;
}
