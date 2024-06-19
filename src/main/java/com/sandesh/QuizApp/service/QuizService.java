package com.sandesh.QuizApp.service;

import com.sandesh.QuizApp.dao.QuestionDao;
import com.sandesh.QuizApp.dao.QuizDao;
import com.sandesh.QuizApp.model.Question;
import com.sandesh.QuizApp.model.QuestionWrapper;
import com.sandesh.QuizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    // this will create quiz
    public ResponseEntity<String> createQuiz(String category, int numQues, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQues);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz Created", HttpStatus.OK);
    }

    // this will fetch all the question from a quiz
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();

        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getCategory(), q.getDifficultyLevel(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUsers.add(qw);  // adding it to List
        }

        return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }
}
