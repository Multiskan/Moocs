package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyQst;

/**
 * Session Bean implementation class GestionSurveyQstSB
 */
@Stateless(name="SurveyQstSb")
@LocalBean
public class GestionSurveyQstSB implements GestionSurveyQstSBRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionSurveyQstSB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void persistSurveyQst(SurveyQst Qst) {
		em.persist(Qst);
		
	}
	@Override
	public void removeSurveyQst(SurveyQst Qst) {
		em.remove(em.merge(Qst));
		
	}
	@Override
	public void updateSurveyQst(SurveyQst Qst) {
		em.merge(Qst);
		
	}
	@Override
	public SurveyQst findByIdSurveyQst(Integer id) {
		SurveyQst Qst= em.find(SurveyQst.class, id);
		if(Qst!=null)
		{
			return Qst;
		}
		return null;
	}
	@Override
	public List<SurveyQst> findQuestionsByIdSurvey(Survey S) {
		List<SurveyQst> listQues=null;
		Query query=em.createQuery("SELECT q FROM SurveyQst q where q.survey = :S", SurveyQst.class).setParameter("S",S);
		//Query query_1=em.createNativeQuery("SELECT * FROM moocs.SurveyQst  where NbrProposition = 4", SurveyQst.class);

		listQues= query.getResultList();
	    return listQues;
	}

	
	@Override
	public List<SurveyQst> findAllQuestion() {
		Query query=em.createQuery("SELECT q FROM SurveyQst q");
		return  query.getResultList();
	}
	@Override
	
	public SurveyQst findLastQst() {
		
		   SurveyQst q=null;
		   Query query = em.createNativeQuery("select * from moocs.surveyqst order by id DESC limit 0,1;", SurveyQst.class);
		
		   q = (SurveyQst) query.getSingleResult();
		return q;
	}
}
