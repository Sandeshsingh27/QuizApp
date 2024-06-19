package com.sandesh.QuizApp.dao;

import com.sandesh.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategoryIgnoreCase(String category);

    List<Question> findByDifficultyLevelIgnoreCase(String level);
}
