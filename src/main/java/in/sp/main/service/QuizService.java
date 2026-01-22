package in.sp.main.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.sp.main.beans.Question;
import in.sp.main.beans.QuestionWrapper;
import in.sp.main.beans.Quiz;
import in.sp.main.beans.Response;
import in.sp.main.dao.QuizDao;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	
	public ResponseEntity<String> createQuiz(String category, int numQ,String title) {
		try {
			Pageable pageable=PageRequest.of(0, numQ);
			List<Question> questionListFromDb=quizDao.findRandomQuestionsByCategory(category,pageable);
		     Quiz quiz= new Quiz();
		     quiz.setQuestionlist(questionListFromDb);
	         quiz.setTitle(title);
	         quizDao.save(quiz);
	         return new ResponseEntity<>("Quiz Created Successfully",HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			 return new ResponseEntity<>("Quiz Creation Failed ",HttpStatus.BAD_REQUEST);
		}
	}


	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
	  try {
		  Optional<Quiz> quiz=quizDao.findById(id);
		  List<Question> questionListFromDb=quiz.get().getQuestionlist();
		  List<QuestionWrapper> questionWrapperList=new ArrayList<>();
		  for ( Question question: questionListFromDb) {
			QuestionWrapper questionWrapper=new QuestionWrapper();
			questionWrapper.setId(question.getId());
			questionWrapper.setQuestionTitle(question.getQuestionTitle());
			questionWrapper.setOption1(question.getOption1());
			questionWrapper.setOption2(question.getOption2());
			questionWrapper.setOption3(question.getOption3());
			questionWrapper.setOption4(question.getOption4());
			questionWrapperList.add(questionWrapper);
			  
		}
		  return new ResponseEntity<>(questionWrapperList,HttpStatus.OK);
		
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
	}
	 
	  
	}


	public ResponseEntity<Integer> resultOfQuiz(Integer id, List<Response> responses) {
		
		try {
			Quiz quiz=quizDao.findById(id).get();
			List<Question> questions=quiz.getQuestionlist();
			int count=0;
			int i=0;
			for(Question question:questions)
			{
				if(question.getRightAnswer().equals(responses.get(i).getResponse()))
						count++;
				i++;
			}
			return new ResponseEntity<Integer>(count, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(0, HttpStatus.BAD_GATEWAY);
		}
	}
}
