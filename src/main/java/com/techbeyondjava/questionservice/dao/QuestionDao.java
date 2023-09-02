package com.techbeyondjava.questionservice.dao;

import com.techbeyondjava.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {


    @Query(value = "SELECT q FROM Question q where (:topic is null or q.topic=:topic) and (:difficultyLevel is null or q.difficultyLevel=:difficultyLevel) order by RAND() LIMIT :noOfQuestions")
    List<Question> getStandardModeQuestions(String topic, String difficultyLevel, Integer noOfQuestions);

    @Query(value = "SELECT q FROM Question q where q.topic=:topic and q.difficultyLevel=:difficultyLevel order by RAND() LIMIT :noOfQuestions")
    List<Question> findByTopicAndDifficultyLevel(String topic, String difficultyLevel, Integer noOfQuestions);


    @Query(value = "SELECT q FROM Question q where q.difficultyLevel='easy' order by RAND() LIMIT 6" +
                    " UNION " +
                    "SELECT q FROM Question q where q.difficultyLevel='medium' order by RAND() LIMIT 6" +
                    " UNION " +
                    "SELECT q FROM Question q where q.difficultyLevel='hard' order by RAND() LIMIT 5" +
                    " UNION " +
                    "SELECT q FROM Question q where q.difficultyLevel='evil' order by RAND() LIMIT 2")
    List<Question> getQuizGameQuestions();


}
