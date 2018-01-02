package edu.esprit.mooc.services.SessionBean;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.PropositionExam;
import edu.esprit.mooc.domain.Entity.QuestionExam;


@Stateless(name="PropositionSB")
@LocalBean
public class GestionPropositionExamSB implements GestionPropositionExamSBRemote{

	@PersistenceContext
	EntityManager em;
	
	public GestionPropositionExamSB(){
		
	}
	@Override
	public void persistPropositionExam(PropositionExam p) {
		em.persist(p);
		
	}

	@Override
	public Boolean removePropositionExam(PropositionExam p) {
		em.remove(em.merge(p));
		return true;
	}

	@Override
	public Boolean updatePropositionExam(PropositionExam p) {
		em.merge(p);
		return true;
	}

	@Override
	public PropositionExam findByIdPropositionExam(Integer id) {
		
		PropositionExam p= em.find(PropositionExam.class, id);
		if(p!=null)
		{
			return p;
		}
		return null;
	}

	@Override
	public PropositionExam findLatesPropositionExam() {
		   PropositionExam p=null;
		   Query query = em.createNativeQuery("select * from mooc.propositionexam order by id DESC limit 0,1;", PropositionExam.class);
		
		   p=(PropositionExam) query.getSingleResult();
		   
		   return p;
				
	}

	@Override
	public List<PropositionExam> findAllPropositionExam() {
		
	
	
			Query query=em.createQuery("select p from PropositionExam p ");
			return query.getResultList();
		
	}
	

}
