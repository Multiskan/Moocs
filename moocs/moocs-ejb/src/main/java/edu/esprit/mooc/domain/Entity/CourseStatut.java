package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CourseStatut
 *
 */
@Entity

public class CourseStatut implements Serializable {

	   
	
	private Integer id_course_statut;
	
	
	
	    @ManyToOne
	    @JoinColumn(name = "id_commitee")
	    private ComiteeMembre comiteemembre;

	    @ManyToOne
	    @JoinColumn(name = "id_course")
	    private Course course ;

	    @Column(name = "statut")
	    private boolean statut;
	
	public ComiteeMembre getComiteemembre() {
			return comiteemembre;
		}
		public void setComiteemembre(ComiteeMembre comiteemembre) {
			this.comiteemembre = comiteemembre;
		}
		public Course getCourse() {
			return course;
		}
		public void setCourse(Course course) {
			this.course = course;
		}

	private static final long serialVersionUID = 1L;

	public CourseStatut() {
		super();
	} 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId_course_statut() {
		return this.id_course_statut;
	}

	public void setId_course_statut(Integer id_course_statut) {
		this.id_course_statut = id_course_statut;
	}   
	public boolean getStatut() {
		return this.statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}
   
}
