package com.techbeyondjava.questionservice.service.impl;

import com.techbeyondjava.questionservice.dao.QuestionDao;
import com.techbeyondjava.questionservice.dto.QuestionDto;
import com.techbeyondjava.questionservice.dto.QuestionsCriteria;
import com.techbeyondjava.questionservice.model.Question;
import com.techbeyondjava.questionservice.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private static final Logger _logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions(QuestionsCriteria questionsCriteria) {
        _logger.info("Called getAllQuestions...");
        return questionDao.getStandardModeQuestions(questionsCriteria.getTopic(), questionsCriteria.getDifficultyLevel(), questionsCriteria.getNoOfQuestions());
    }

    @Override
    public Question addQuestion(QuestionDto questionDto) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);


        _logger.info("Called addQuestion...{}", question);
        question.setCreatedDate(new Date());
        return questionDao.save(question);
    }

    @Override
    public Question updateQuestion(QuestionDto questionDto) {
        _logger.info("Called updateQuestion...{}", questionDto);

        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);


        question.setModifiedDate(new Date());
        return questionDao.save(question);
    }

    @Override
    public List<Question> addAllQuestions(List<QuestionDto> questionDtoList) {
        _logger.info("Called addAllQuestions questionDtoList size : {}", questionDtoList.size());
        List<Question> questionList = new ArrayList<>();

        for (QuestionDto eachQuestionDto : questionDtoList) {
            eachQuestionDto.setCreatedDate(new Date());
            Question question = new Question();
            BeanUtils.copyProperties(eachQuestionDto, question);
            questionList.add(question);
        }

        return questionDao.saveAll(questionList);
    }

    @Override
    public List<Question> getQuizGameQuestions() {
        return questionDao.getQuizGameQuestions();
    }

    @Override
    public List<Question> removeQuestion(Integer questionId) {
        questionDao.deleteById(questionId);
        return null;
    }

}
