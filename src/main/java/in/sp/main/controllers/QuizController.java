package in.sp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.beans.QuestionWrapper;
import in.sp.main.beans.Response;
import in.sp.main.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
@Autowired
QuizService quizService;
@PostMapping("create")
public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title)
{
		return quizService.createQuiz(category, numQ, title);
}
@GetMapping("get")
public ResponseEntity<List<QuestionWrapper>> getQuiz(@RequestParam int id)
{
	return quizService.getQuiz(id);
}
@PostMapping("submit/{id}")
public ResponseEntity<Integer> resultOfQuiz(@PathVariable Integer id,@RequestBody List<Response> responses)
{
	return quizService.resultOfQuiz(id,responses);
}
}
