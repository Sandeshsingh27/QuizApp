package com.sandesh.QuizApp.service;

import com.sandesh.QuizApp.dao.QuestionDao;
import com.sandesh.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategoryIgnoreCase(category);
    }

    public List<Question> getQuestionsByDifficultyLevel(String level) {
        return questionDao.findByDifficultyLevelIgnoreCase(level);
    }

    public Question addQuestion(Question question) {
        return questionDao.save(question);
    }
}
