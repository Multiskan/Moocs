
package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SurveyQst
 *
 */
@Entity

public class SurveyQst implements Serializable {

	
	private Integer Id;
	private String Question;
	private Integer NbrProposition;
	private Survey survey;
	private List<SurveyProposition> list_SurveyProposition=new ArrayList<SurveyProposition>();
	
	private static final long serialVersionUID = 1L;

	public SurveyQst() {
		super();
	}   
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	
	public String getQuestion() {
		return this.Question;
	}

	public void setQuestion(String Question) {
		this.Question = Question;
	}   
	public Integer getNbrProposition() {
		return this.NbrProposition;
	}

	public void setNbrProposition(Integer NbrProposition) {
		this.NbrProposition = NbrProposition;
	}
	@ManyToOne
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	
	@OneToMany(mappedBy="survQst")
	public List<SurveyProposition> getList_SurveyProposition() {
		return list_SurveyProposition;
	}
	public void setList_SurveyProposition(List<SurveyProposition> list_SurveyProposition) {
		this.list_SurveyProposition = list_SurveyProposition;
	}
	
	
   
}
