package com.quizapp.Quiz_App;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ques")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
	private int id;

	private String question;

	@OneToOne
	@JoinColumn(name = "ans_id")
	private Answer ans;

//	private Answer answer;
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Options> option;

	public Answer getAns() {
		return ans;
	}

	public void setAns(Answer ans) {
		this.ans = ans;
	}

	public Question() {
		super();

	}

	public Question(String question, Answer ans) {
		super();
		this.question = question;
		this.ans = ans;

	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Options> getOption() {
		return option;
	}

	public void setOption(List<Options> option) {
		this.option = option;
	}

}
