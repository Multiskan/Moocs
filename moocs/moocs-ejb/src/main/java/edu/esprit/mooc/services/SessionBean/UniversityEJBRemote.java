package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.University;

@Remote
public interface UniversityEJBRemote {
	public List<University> getAllUniversity();
}
