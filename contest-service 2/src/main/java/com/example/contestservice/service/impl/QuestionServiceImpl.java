package com.example.contestservice.service.impl;

import com.example.contestservice.dto.QuestionsDTO;
import com.example.contestservice.entity.Questions;
import com.example.contestservice.repository.QuestionRepo;
import com.example.contestservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    QuestionRepo questionRepo;

    @Override
    public Optional<Questions> getContestById(String contestId) {
        return questionRepo.findById(contestId);
    }

    @Override
    public String addQuestion(QuestionsDTO questionsData, String contestId) {
        if(questionRepo.existsById(contestId)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(contestId));
            Update update = new Update();
            update.addToSet("questionsData", questionsData);
            mongoTemplate.findAndModify(query, update, Questions.class);
        }
        else{
            List<QuestionsDTO> questionsDataList = new ArrayList<>();
            questionsDataList.add(questionsData);
            Questions questions = new Questions();
            questions.setContestId(contestId);
            questions.setQuestionsData(questionsDataList);
            questionRepo.save(questions);

        }
        return "added";
    }

    @Override
    public Integer incrementIndex(String contestId) {

        Optional<Questions> questionsOptional = questionRepo.findById(contestId);
        Questions questions = null;
        if(questionsOptional.isPresent())
        {
            questions=questionsOptional.get();
            questions.setIndex(questions.getIndex()+1);
            questionRepo.save(questions);
        }

        return 1;
    }
}
