package edu.esprit.mooc.domain.Entity;

import edu.esprit.mooc.domain.Entity.User;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trainer
 *
 */
@Entity
@DiscriminatorValue(value = "trainer")
public class Trainer extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Course> courses;
	
	public Trainer() {
		super();
	}
	@OneToMany(mappedBy = "trainer")
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

}
