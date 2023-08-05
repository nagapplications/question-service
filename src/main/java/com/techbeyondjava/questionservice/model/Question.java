package com.techbeyondjava.questionservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "option1", nullable = false)
    private String option1;

    @Column(name = "option2", nullable = false)
    private String option2;

    @Column(name = "option3", nullable = false)
    private String option3;

    @Column(name = "option4", nullable = false)
    private String option4;

    @Column(name = "right_answer", nullable = false)
    private String rightAnswer;

    @Column(name = "difficulty_level", nullable = false)
    private String difficultyLevel;

    @Column(name = "topic", nullable = false)
    private String topic;
    @Transient
    private Date createdDate;
    @Transient
    private Date modifiedDate;
}
