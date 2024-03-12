package com.examportal.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.app.entity.exam.Category;
import com.examportal.app.entity.exam.Quiz;
import com.examportal.app.service.QuizService;


@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizContoller {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		 Quiz quiz1 = this.quizService.addQuiz(quiz);
		 return ResponseEntity.ok(quiz1);
	}
	
	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
		return this.quizService.getQuiz(quizId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizes(){
		return ResponseEntity.ok(this.quizService.getQuizes());
	}
	
	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return this.quizService.updateQuiz(quiz);
	}
	
	@DeleteMapping("/{quizId}")
	public void deletQuiz(@PathVariable("quizId") Long quizId) {
		this.quizService.deleteQuiz(quizId);
	}
	
	//Specific quize URL
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizesOfCategory(@PathVariable("cid") Long cid) {
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizesOfCategory(category);
	}
	
	// Get Active Quizes
	@GetMapping("/active")
	public List<Quiz> getActiveQuizes(){
		return this.quizService.getActiveQuizes();
	}
	
	// Get Active Quizes of category
		@GetMapping("/category/active/{cid}")
		public List<Quiz> getActiveQuizes(@PathVariable("cid") Long cid){
			Category category = new Category();
			category.setCid(cid);
			return this.quizService.getActiveQuizesOfCategory(category);
		}
}
