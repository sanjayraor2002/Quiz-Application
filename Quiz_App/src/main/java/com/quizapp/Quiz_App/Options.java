package com.quizapp.Quiz_App;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "opt")
public class Options {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String opt;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private Question question;

	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Options(String opt, Question question) {
		super();
		this.opt = opt;
		this.question = question;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
