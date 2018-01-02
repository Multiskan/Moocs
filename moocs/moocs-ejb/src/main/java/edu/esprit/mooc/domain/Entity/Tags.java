package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import edu.esprit.mooc.domain.Entity.Course;


/**
 * Entity implementation class for Entity: Tags
 *
 */
@Entity

public class Tags implements Serializable {

	
	private String nomtag;   
	private Integer idtag;
	private Course course;
	//private List<Course> course= new ArrayList<Course>();
	private static final long serialVersionUID = 1L;

	public Tags() {
		super();
	}   
	public String getNomtag() {
		return this.nomtag;
	}

	public void setNomtag(String nomtag) {
		this.nomtag = nomtag;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdtag() {
		return this.idtag;
	}

	public void setIdtag(Integer idtag) {
		this.idtag = idtag;
	}
	@ManyToOne
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	/*@ManyToMany(cascade=CascadeType.ALL)
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}*/
	
}
