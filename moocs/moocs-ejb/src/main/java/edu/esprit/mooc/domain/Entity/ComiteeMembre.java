package edu.esprit.mooc.domain.Entity;

import edu.esprit.mooc.domain.Entity.User;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ComiteeMembre
 *
 */
@Entity
@DiscriminatorValue(value="commitee_membre")
public class ComiteeMembre extends User implements Serializable {

	@OneToMany(mappedBy = "comiteemembre")
    private Set<CourseStatut> coursestatuts  = new HashSet<CourseStatut>();
	
	private static final long serialVersionUID = 1L;

	public ComiteeMembre() {
		super();
	}
   
}
