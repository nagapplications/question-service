package com.techbeyondjava.questionservice.dto;

import lombok.Data;

@Data
public class QuestionsCriteria {
    private String topic;
    private Integer noOfQuestions;
    private String difficultyLevel;
}
