package in.sp.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.beans.Question;
import java.util.List;


public interface QuestionDao extends JpaRepository<Question, Integer>{
List<Question> findByCategory(String category);
}
