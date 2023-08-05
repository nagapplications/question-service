package com.techbeyondjava.questionservice.controller;

import com.techbeyondjava.questionservice.dto.QuestionDto;
import com.techbeyondjava.questionservice.model.Question;
import com.techbeyondjava.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/getQuestions")
    public List<Question> getAllQuestions(@RequestBody QuestionDto questionDto) {

        List<Question> questionList =  questionService.getAllQuestions(questionDto);

        System.out.println(questionList);

        return questionList;
    }

    @PostMapping("/addQuestion")
    public List<Question> addQuestion(@RequestBody Question Question) {

        List<Question> questionList =  questionService.addQuestion(Question);

        System.out.println(questionList);

        return questionList;
    }

}
