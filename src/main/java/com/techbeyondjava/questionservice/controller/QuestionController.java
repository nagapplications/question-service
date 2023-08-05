package com.techbeyondjava.questionservice.controller;

import com.techbeyondjava.questionservice.dto.QuestionDto;
import com.techbeyondjava.questionservice.dto.QuestionsCriteria;
import com.techbeyondjava.questionservice.model.Question;
import com.techbeyondjava.questionservice.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private static final Logger _logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionService questionService;

    @PostMapping({"/addAllQuestions"})
    public void addAllQuestions(@RequestBody List<QuestionDto> questionDtoList) {
        _logger.info("Called addAllQuestion, questionDtoList : {}", questionDtoList);
        List<Question> savedQuestionList = questionService.addAllQuestions(questionDtoList);
        _logger.info("Saved Questions : {}", savedQuestionList);
    }

    @PostMapping({"/updateQuestion"})
    public List<Question> updateQuestion(@RequestBody QuestionDto questionDto) throws Exception {
        _logger.info("Updating Question Id : {}", questionDto.getId());
        if (questionDto.getId() == 0) {
            throw new Exception("No question Id found!");
        }
        _logger.info("Called updateQuestion, question : {}", questionDto);
        Question updatedQuestion = questionService.updateQuestion(questionDto);

        _logger.info("Updated Question : {}", updatedQuestion);
        return null;
    }

    @GetMapping("/getQuestions")
    public List<Question> getAllQuestions(@RequestBody QuestionsCriteria questionsCriteria) {
        _logger.info("Called getAllQuestions, questionDto : {}", questionsCriteria);
        List<Question> questionList = questionService.getAllQuestions(questionsCriteria);
        System.out.println(questionList);
        return questionList;
    }


    @GetMapping("/getQuizGameQuestions")
    public List<Question> getQuizGameQuestions() {
        _logger.info("Called getQuizGameQuestions...");
        List<Question> quizGameQuestionList = questionService.getQuizGameQuestions();
        _logger.info("Called getQuizGameQuestions, questionDto : {}", quizGameQuestionList);
        return quizGameQuestionList;
    }

}
