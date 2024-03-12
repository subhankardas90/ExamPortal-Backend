package com.examportal.app.service;

import java.util.Set;

import com.examportal.app.entity.exam.Category;

public interface CategoryService {
	
	Category addCategory(Category category);
	
	Category updateCategory(Category category);
	
	Set<Category> getCategories();
	
	Category getCategory(Long categoryId);
	
	void deleteCategory(Long categoryId);

}
