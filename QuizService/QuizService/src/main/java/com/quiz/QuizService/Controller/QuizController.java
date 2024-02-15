package com.quiz.QuizService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizService.Entity.Quiz;
import com.quiz.QuizService.Service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    private QuizService quizService;

    //create
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    //get all
    @GetMapping
    public List<Quiz> getAllQuizes(){
      return quizService.get();
    }

    //getbyId
    @GetMapping("/{Id}")
    public Quiz getById(@PathVariable (value = "Id") Long Id){
        return quizService.get(Id);
    }

}
