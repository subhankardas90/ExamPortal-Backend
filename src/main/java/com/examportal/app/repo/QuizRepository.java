package com.examportal.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.app.entity.exam.Category;
import com.examportal.app.entity.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	public List<Quiz> findBycategory(Category category);
	
	//Fetch Active Quize
	public List<Quiz> findByActive(Boolean b);
	

	//Fetch Active Quize
	public List<Quiz> findByCategoryAndActive(Category c, Boolean b);
	
	

}
