package edu.esprit.mooc.domain.Entity;

import edu.esprit.mooc.domain.Entity.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@DiscriminatorValue(value="admin")
public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
   
}
