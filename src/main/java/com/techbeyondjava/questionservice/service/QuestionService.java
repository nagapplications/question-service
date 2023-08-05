package com.techbeyondjava.questionservice.service;

import com.techbeyondjava.questionservice.dto.QuestionDto;
import com.techbeyondjava.questionservice.dto.QuestionsCriteria;
import com.techbeyondjava.questionservice.model.Question;

import java.util.List;


public interface QuestionService {
    List<Question> getAllQuestions(QuestionsCriteria questionsCriteria);

    Question addQuestion(QuestionDto questionDto);

    List<Question> removeQuestion(Integer questionId);

    Question updateQuestion(QuestionDto questionDto);


    List<Question> addAllQuestions(List<QuestionDto> questionDtoList);

    List<Question> getQuizGameQuestions();
}
