package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;


/**
 * Session Bean implementation class GestionSurveyPropositionSB
 */
@Stateless(name="SurveyPropositionSb")
@LocalBean
public class GestionSurveyPropositionSB implements GestionSurveyPropositionSBRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public GestionSurveyPropositionSB() {
       
    }

	@Override
	public void persistSurveyProposition(SurveyProposition prop) {
		 em.persist(prop);
		
	}

	@Override
	public void removeSurveyProposition(SurveyProposition prop) {
		 em.persist(em.merge(prop));
	
	}

	@Override
	public void updateSurveyProposition(SurveyProposition prop) {
		em.merge(prop);
		
	}

	@Override
	public SurveyProposition findByIdSurveyProposition(Integer id) {
		SurveyProposition prop= em.find(SurveyProposition.class, id);
		if(prop!=null)
		{
			return prop;
		}
		return null;
	
	}

	@Override
	public Integer ChartNbrePropbyQst() {
		Query query=em.createQuery("SELECT sum(p.nbrReponse) FROM SurveyProposition p group by(p.survQst_id) ");
		
		return (Integer) query.getSingleResult();
	}

	@Override
	public List<SurveyProposition> findPropositionByIDQuestion(SurveyQst Q) {
		List<SurveyProposition> listProp=null;
		Query query=em.createQuery("SELECT p FROM SurveyProposition p where p.survQst = :Q" , SurveyProposition.class).setParameter("Q", Q);
		
		//Query query_1=em.createNativeQuery("SELECT * FROM moocs.SurveyQst  where NbrProposition = 4", SurveyQst.class);

		listProp= query.getResultList();
	    return listProp;
	}

	@Override
	public List<SurveyProposition> findAllProposition() {
		List <SurveyProposition> list=null;
		Query query=em.createQuery("SELECT p FROM SurveyProposition p ",SurveyProposition.class);
		  list=query.getResultList();
		  return list;
	}
	

}
