package in.sp.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.sp.main.beans.Question;
import in.sp.main.dao.QuestionDao;


@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try {
			return new ResponseEntity<List<Question>>(questionDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		
		try {
			return new ResponseEntity<List<Question>>(questionDao.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
		 
		
	}
	
	
	public ResponseEntity<Boolean> addQuestion(Question question) {
		
		try {
			questionDao.save(question);
			 return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public  ResponseEntity<Boolean> deleteByIdQuestion(Integer id) {
		try {
			questionDao.deleteById(id);
			 return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
			 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ResponseEntity<Boolean>  updateQuestion(Question question) {
		try {
			questionDao.save(question);
			 return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
			 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
}
