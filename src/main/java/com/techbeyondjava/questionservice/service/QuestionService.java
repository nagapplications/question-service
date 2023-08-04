package com.techbeyondjava.questionservice.service;

import com.techbeyondjava.questionservice.dto.QuestionDto;
import com.techbeyondjava.questionservice.model.Question;

import java.util.List;


public interface QuestionService {
    List<Question> getAllQuestions(QuestionDto questionDto);
}
