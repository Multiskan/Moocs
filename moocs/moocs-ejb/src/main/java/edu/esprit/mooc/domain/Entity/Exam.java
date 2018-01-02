package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Exam
 *
 */
@Entity

public class Exam implements Serializable {

	
	private Integer id;
	private String nom_Examen;
	private List<QuestionExam> list_QuestionExam=new ArrayList<QuestionExam>();
	private Course course;
	private static final long serialVersionUID = 1L;

	public Exam() {
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
	public String getNom_Examen() {
		return this.nom_Examen;
	}

	public void setNom_Examen(String nom_Examen) {
		this.nom_Examen = nom_Examen;
	}
   
	@OneToMany(mappedBy="exam")
	public List<QuestionExam> getList_QuestionExam() {
		return list_QuestionExam;
	}
	public void setList_QuestionExam(List<QuestionExam> list_QuestionExam) {
		this.list_QuestionExam = list_QuestionExam;
	}
	@OneToOne
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
