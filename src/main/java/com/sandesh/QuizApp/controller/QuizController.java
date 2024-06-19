package com.sandesh.QuizApp.controller;

import com.sandesh.QuizApp.model.QuestionWrapper;
import com.sandesh.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQues, @RequestParam String title){
        return quizService.createQuiz(category, numQues, title);
    }

    @GetMapping("/get/{quiz_id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("quiz_id") int id){
        return quizService.getQuizQuestions(id);
    }
}
