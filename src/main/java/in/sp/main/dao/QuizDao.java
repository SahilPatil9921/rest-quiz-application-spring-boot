package in.sp.main.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import in.sp.main.beans.Question;
import in.sp.main.beans.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

    @Query(
      value = "SELECT * FROM question q WHERE q.category = ?1 ORDER BY RAND()",
      nativeQuery = true
    )
    List<Question> findRandomQuestionsByCategory(
        String category,
        Pageable pageable
    );
}

