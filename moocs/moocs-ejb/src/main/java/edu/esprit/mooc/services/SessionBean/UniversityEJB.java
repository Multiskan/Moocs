package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.Chapter;
import edu.esprit.mooc.domain.Entity.University;

@Stateless
public class UniversityEJB implements UniversityEJBRemote,UniversityEJBLocal{
public UniversityEJB(){
	
}

@PersistenceContext
private EntityManager entityManager;




@Override
public List<University> getAllUniversity() {
Query query=entityManager.createQuery("select c from University c ");
return  query.getResultList();

}




}
