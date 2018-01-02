package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PropositionExam
 *
 */
@Entity

public class PropositionExam implements Serializable {

	   

	private Integer id;
	private String proposition;
	private Integer correct;
	private QuestionExam questionExam;
	private static final long serialVersionUID = 1L;

	public PropositionExam() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getProposition() {
		return this.proposition;
	}

	public void setProposition(String proposition) {
		this.proposition = proposition;
	}   
	public Integer getCorrect() {
		return this.correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	
	@ManyToOne
	public QuestionExam getQuestionExam() {
		return questionExam;
	}
	public void setQuestionExam(QuestionExam questionExam) {
		this.questionExam = questionExam;
	}
   
	
}
