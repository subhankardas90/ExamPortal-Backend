package com.examportal.app.service;

import java.util.Set;

import com.examportal.app.entity.exam.Question;
import com.examportal.app.entity.exam.Quiz;

public interface QuestionService {
	
	Question addQuestion(Question question);
	
	Question updateQuestion(Question question);
	
	Set<Question> getQuestions();
	
	Question getQuestion(Long questionId);
	
	Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	void deleteQuestion(Long questionId);

}
