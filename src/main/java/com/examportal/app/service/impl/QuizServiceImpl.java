package com.examportal.app.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.app.entity.exam.Category;
import com.examportal.app.entity.exam.Quiz;
import com.examportal.app.repo.QuizRepository;
import com.examportal.app.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizes() {
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizID) {
		return this.quizRepository.findById(quizID).get();
	}

	@Override
	public void deleteQuiz(Long quizID) {
		this.quizRepository.deleteById(quizID);
		
	}

	@Override
	public List<Quiz> getQuizesOfCategory(Category category) {
		return this.quizRepository.findBycategory(category);
	}

	//Get Active Quizes
	@Override
	public List<Quiz> getActiveQuizes() {
		return this.quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizesOfCategory(Category category) {
		return this.quizRepository.findByCategoryAndActive(category, true);
	}
	
	
	

}
