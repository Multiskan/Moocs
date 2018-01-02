package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Survey
 *
 */
@Entity

public class Survey implements Serializable {

	
	private Integer Id;
	private String NomSurvey;
	private Integer NbrQst;
	private List<SurveyQst> list_SurveyQst=new ArrayList<SurveyQst>();
	
	private static final long serialVersionUID = 1L;

	public Survey() {
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
	public String getNomSurvey() {
		return this.NomSurvey;
	}

	public void setNomSurvey(String NomSurvey) {
		this.NomSurvey = NomSurvey;
	}   

	@OneToMany(mappedBy="survey")
	public List<SurveyQst> getList_SurveyQst() {
		return list_SurveyQst;
	}
	public void setList_SurveyQst(List<SurveyQst> list_SurveyQst) {
		this.list_SurveyQst = list_SurveyQst;
	}
	public Integer getNbrQst() {
		return NbrQst;
	}
	public void setNbrQst(Integer nbrQst) {
		NbrQst = nbrQst;
	}
	
	
   
}
