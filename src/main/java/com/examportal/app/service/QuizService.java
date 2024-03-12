package com.examportal.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.examportal.app.entity.exam.Category;
import com.examportal.app.entity.exam.Quiz;

public interface QuizService {
	
	Quiz addQuiz(Quiz quiz);
	
	Quiz updateQuiz(Quiz quiz);
	
	Set<Quiz> getQuizes();
	
	Quiz getQuiz(Long quizID);
	
	void deleteQuiz(Long quizID);

	public List<Quiz> getQuizesOfCategory(Category category);
	
	public List<Quiz> getActiveQuizes();
	
	public List<Quiz> getActiveQuizesOfCategory(Category category);

	

}
