package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.Survey;


/**
 * Session Bean implementation class GestionSurveySB
 */
@Stateless(name="SurveySb")
@LocalBean
public class GestionSurveySB implements GestionSurveySBRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public GestionSurveySB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persistSurvey(Survey s) {
		em.persist(s);
		
	}

	@Override
	public void removeSurvey(Survey s) {
		em.remove(em.merge(s));
		
	}

	@Override
	public void updateSurvey(Survey s) {
		em.merge(s);
		
	}

	@Override
	public Survey findByIdSurvey(Integer id) {
		
		Survey s= em.find(Survey.class, id);
		if(s!=null)
		{
			return s;
		}
		return null;
	}

	@Override
	public Survey findLatesSurvey() {
		   Survey s=null;
		   Query query = em.createNativeQuery("select * from moocs.survey order by id DESC limit 0,1;", Survey.class);
		
		   s=(Survey) query.getSingleResult();
		   
		   return s;
				
	}

	@Override
	public List<Survey> findAllSurveys() {
		
	
	
			Query query=em.createQuery("select s from Survey s  ");
			return query.getResultList();
		
	}

}
