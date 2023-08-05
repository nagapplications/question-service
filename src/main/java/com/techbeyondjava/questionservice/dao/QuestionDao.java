package com.techbeyondjava.questionservice.dao;

import com.techbeyondjava.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT q FROM Question q where q.topic=:topic order by RANDOM() LIMIT :noOfQuestions")
    List<Question> getQuestionsByTopic(String topic, int noOfQuestions);

    @Query(value = "SELECT q FROM Question q where q.topic=:topic order by RANDOM() LIMIT 6")
    List<Question> getQuizGameQuestions(String topic);


}
