package com.example.contestservice.entity;


import com.example.contestservice.dto.RankingDTO;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = "Ranking")
public class Ranking {

    @Id
    private String contestId;
    private List<RankingDTO> usersList;
}