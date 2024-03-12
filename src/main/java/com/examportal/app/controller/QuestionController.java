package com.examportal.app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.examportal.app.entity.exam.Question;
import com.examportal.app.entity.exam.Quiz;
import com.examportal.app.service.QuestionService;
import com.examportal.app.service.QuizService;



@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		 Question qstn = this.questionService.addQuestion(question);
		 return ResponseEntity.ok(qstn);
	}
	
	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable("questionId") Long questionId) {
		return this.questionService.getQuestion(questionId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuestions(){
		return ResponseEntity.ok(this.questionService.getQuestions());
	}
	
	@PutMapping("/")
	public Question updateQuestion(@RequestBody Question question) {
		return this.questionService.updateQuestion(question);
	}
	
	@DeleteMapping("/{questionId}")
	public void deletQuestion(@PathVariable("questionId") Long questionId) {
		this.questionService.deleteQuestion(questionId);
	}
	
	//Get All qn oof any Quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
//		Quiz quiz = new Quiz();
//		quiz.setQid(quizId);
//		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz); // pass quiz Object
//		return ResponseEntity.ok(questionsOfQuiz);
		
		//1.load Quiz
		Quiz quiz = this.quizService.getQuiz(qid);
		Set<Question> questions = quiz.getQuestions();
		List list = new ArrayList<>(questions);
		if(list.size()>Integer.parseInt(quiz.getNoOfQuestions())) {
			list=list.subList(0, Integer.parseInt(quiz.getNoOfQuestions()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
		
		
	}
	
	//Get All qn oof any Quiz
		@GetMapping("/quiz/all/{qid}")
		public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid){
			Quiz quiz = new Quiz();
			quiz.setQid(qid);
			Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
			return ResponseEntity.ok(questionsOfQuiz);
		}

}
