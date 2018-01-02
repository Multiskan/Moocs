package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import edu.esprit.mooc.domain.Entity.Tags;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

public class Course implements Serializable {

	
	private Integer id_course;
	private String nom_course;
	private Date date_debut;
	private Integer duree;
	private String video;
	private String photo;
	private String pre_requis;
	private String objectif;
	private String statut;
	private Trainer trainer;
	private List<Tags>listtags= new ArrayList<Tags>();
	
	private static final long serialVersionUID = 1L;

	
	@OneToMany(mappedBy = "course")
    private Set<CourseStatut> coursestatuts = new HashSet<CourseStatut>(); 
	public Course() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId_course() {
		return this.id_course;
	}

	public void setId_course(Integer id_course) {
		this.id_course = id_course;
	}   
	public String getNom_course() {
		return this.nom_course;
	}

	public void setNom_course(String nom_course) {
		this.nom_course = nom_course;
	}   
	public Date getDate_debut() {
		return this.date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}   
	public Integer getDuree() {
		return this.duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}   
	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}   
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}   
	public String getPre_requis() {
		return this.pre_requis;
	}

	public void setPre_requis(String pre_requis) {
		this.pre_requis = pre_requis;
	}   
	public String getObjectif() {
		return this.objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	@ManyToOne
	@JoinColumn(name="id_trainer")
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "*******  Course_name: " + nom_course + " *********   statut:" + statut + "*********";
	}
	
	@OneToMany(mappedBy="course")
	public List<Tags> getListtags() {
		return listtags;
	}
	public void setListtags(List<Tags> listtags) {
		this.listtags = listtags;
	}
	
   
}
