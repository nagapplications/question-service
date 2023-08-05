package com.techbeyondjava.questionservice.service.impl;

import com.techbeyondjava.questionservice.dao.QuestionDao;
import com.techbeyondjava.questionservice.dto.QuestionDto;
import com.techbeyondjava.questionservice.model.Question;
import com.techbeyondjava.questionservice.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    QuestionDao questionDao;
    @Override
    public List<Question> getAllQuestions(QuestionDto questionDto) {

        Question question = new Question();
        question.setQuestion("first question");

        List<Question> questionList = questionDao.findAll();
        return Arrays.asList(question);
    }
}
