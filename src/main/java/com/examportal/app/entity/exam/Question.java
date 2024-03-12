package com.examportal.app.entity.exam;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "questionId", nullable = false)
	private Long quesId;
	
	@Column(length = 5000)
	private String content;
	
	private String image;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;
	
	private String answer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;

}
