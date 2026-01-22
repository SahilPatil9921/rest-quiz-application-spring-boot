package in.sp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.beans.Question;
import in.sp.main.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
@GetMapping("allQuestions")
	public ResponseEntity<List<Question>>  getAllQuestions()
	{
		return questionService.getAllQuestions();
	}

@GetMapping("category/{category}")
public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
{
	return questionService.getQuestionsByCategory(category);
}

@PostMapping("add")
public ResponseEntity<Boolean> addQuestion(@RequestBody Question question)
{
	return questionService.addQuestion(question);
}

@DeleteMapping("delete")
public ResponseEntity<Boolean> deleteByIdQuestion(@RequestParam("id")Integer id)
{
	return questionService.deleteByIdQuestion(id);
}

@PutMapping("update")
public ResponseEntity<Boolean> updateQuestion(@RequestBody Question question)
{
	return questionService.updateQuestion(question);
}
}
