package com.quiz.QuizService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.QuizService.Entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long>{
    
}
