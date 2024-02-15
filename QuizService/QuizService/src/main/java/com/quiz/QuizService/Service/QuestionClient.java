package com.quiz.QuizService.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.QuizService.Entity.Question;

//@FeignClient(url = "http://localhost:8081" , value="Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getAllQuestionsofQuiz(@PathVariable Long quizId);   
}
