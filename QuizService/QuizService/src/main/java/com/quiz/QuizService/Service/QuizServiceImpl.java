package com.quiz.QuizService.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizService.Entity.Question;
import com.quiz.QuizService.Entity.Quiz;
import com.quiz.QuizService.Repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes =  quizRepository.findAll();
        List<Quiz> newQuizList =  quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getAllQuestionsofQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }


    @Override
    public Quiz get(Long id) {
       Quiz quiz =  quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found")); 
       List<Question>  questions = questionClient.getAllQuestionsofQuiz(quiz.getId());
       quiz.setQuestions(questions);
       return quiz;
    }

    
}
