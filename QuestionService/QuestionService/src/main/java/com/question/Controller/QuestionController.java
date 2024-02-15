package com.question.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.Entity.Question;
import com.question.Service.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable (value = "id") Long id){
        return questionService.getQuestion(id);
    }

    //Get all questions of specific quiz
    @GetMapping("/quiz/{id}")
    public List<Question> getAllQuestionsofQuiz(@PathVariable Long id){
        return questionService.getQuestionsByQuizId(id);
    }
}
