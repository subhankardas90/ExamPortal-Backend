package com.examportal.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.app.entity.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
