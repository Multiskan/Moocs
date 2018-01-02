package edu.esprit.mooc.domain.Entity;

import edu.esprit.mooc.domain.Entity.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Learner
 *
 */
@Entity
@DiscriminatorValue(value="learner")
public class Learner extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Learner() {
		super();
	}
   
}
