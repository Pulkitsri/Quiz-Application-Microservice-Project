package com.quiz.QuizService.Service;

import java.util.List;

import com.quiz.QuizService.Entity.Quiz;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> get();
    Quiz get(Long id);
} 