package com.techbeyondjava.questionservice.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;

@Data
public class Question {

    private Integer id;
    private String Question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String difficultyLevel;
    private String rightAnswer;
    private String category;
}
