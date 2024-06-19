package com.sandesh.QuizApp.controller;


import com.sandesh.QuizApp.model.Question;
import com.sandesh.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable("category") String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/level/{level}")
    public List<Question> getQuestionsByDifficultyLevel(@PathVariable("level") String level){
        return questionService.getQuestionsByDifficultyLevel(level);
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
