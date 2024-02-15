package com.question.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.Entity.Question;
import com.question.Repository.QuestionRepository;

@Service
public class QuesitonServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);   
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question Not Found"));
    }

    @Override
    public List<Question> getQuestionsByQuizId(Long quizId) {
        return questionRepository.getQuestionsByQuizId(quizId);
    }


}
