package com.question.Service;

import java.util.List;
import com.question.Entity.Question;

public interface QuestionService {

    public Question addQuestion(Question question);
    public List<Question> getAllQuestion();
    public Question getQuestion(Long id);
    public List<Question> getQuestionsByQuizId(Long quizId);
}
