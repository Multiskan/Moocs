package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SurveyProposition
 *
 */
@Entity

public class SurveyProposition implements Serializable {

	
	private Integer Id;
	private String Proposition;
	private Integer NbrReponse;
	private SurveyQst survQst;
	private static final long serialVersionUID = 1L;

	public SurveyProposition() {
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
	
	public String getProposition() {
		return this.Proposition;
	}

	public void setProposition(String Proposition) {
		this.Proposition = Proposition;
	}
	@ManyToOne
	public SurveyQst getSurvQst() {
		return survQst;
	}
	public void setSurvQst(SurveyQst survQst) {
		this.survQst = survQst;
	}
	public Integer getNbrReponse() {
		return NbrReponse;
	}
	public void setNbrReponse(Integer nbrReponse) {
		NbrReponse = nbrReponse;
	}
	
}
