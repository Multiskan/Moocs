package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: QuestionExam
 *
 */
@Entity

public class QuestionExam implements Serializable {

	
	private Integer id;
	private String question;
	public Exam exam;
	private List<PropositionExam> list_PropositionExam=new ArrayList<PropositionExam>();
	
	private static final long serialVersionUID = 1L;

	public QuestionExam() {
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
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@ManyToOne
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	@OneToMany(mappedBy="questionExam")
	public List<PropositionExam> getList_PropositionExam() {
		return list_PropositionExam;
	}
	public void setList_PropositionExam(List<PropositionExam> list_PropositionExam) {
		this.list_PropositionExam = list_PropositionExam;
	}
	
	
   
}
