package com.example.contestservice.entity;


import com.example.contestservice.dto.QuestionsDTO;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = "Questions")
public class Questions {

    @Id
    private String contestId;
    private Integer index=0;
    private List<QuestionsDTO> questionsData;
}

