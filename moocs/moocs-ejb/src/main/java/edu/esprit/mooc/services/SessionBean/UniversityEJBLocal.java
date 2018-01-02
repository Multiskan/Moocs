package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.LocalBean;

import edu.esprit.mooc.domain.Entity.University;

@LocalBean
public interface UniversityEJBLocal {
	public List<University> getAllUniversity();
}
