package com.sandesh.QuizApp.service;

import com.sandesh.QuizApp.dao.QuestionDao;
import com.sandesh.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Question updateQuestion(int id, Question question) {
        Optional<Question> optionalQuestion = questionDao.findById(id);
        if (optionalQuestion.isPresent()) {
            Question existingQuestion = optionalQuestion.get();
            existingQuestion.setCategory(question.getCategory());
            existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
            existingQuestion.setQuestionTitle(question.getQuestionTitle());
            existingQuestion.setOption1(question.getOption1());
            existingQuestion.setOption2(question.getOption2());
            existingQuestion.setOption3(question.getOption3());
            existingQuestion.setOption4(question.getOption4());
            existingQuestion.setRightAnswer(question.getRightAnswer());
            return questionDao.save(existingQuestion);
        } else {
            return null; // or throw an exception if preferred
        }
    }

    public void deleteQuestion(int id) {
        questionDao.deleteById(id);
    }
}
