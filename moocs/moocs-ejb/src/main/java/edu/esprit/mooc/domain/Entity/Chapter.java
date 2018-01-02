package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chapter implements Serializable {
	
	private int id ;
	private String nom_chapter ;
	private String video ;
	private String pdf ;
	private Course course ;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name ="id_course")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	} 
	public String getNom_chapter() {
		return nom_chapter;
	}
	public void setNom_chapter(String nom_chapter) {
		this.nom_chapter = nom_chapter;
	}
	
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
