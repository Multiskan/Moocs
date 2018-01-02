package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.Exam;
import edu.esprit.mooc.domain.Entity.QuestionExam;


@Stateless
@LocalBean
public class GestionExamSB implements GestionExamSBRemote{

	@PersistenceContext
	EntityManager em;
	
	public GestionExamSB(){
		
	}


	@Override
	public void persistExam(Exam e) {
		em.persist(e);
		
	}

	@Override
	public Boolean removeExam(Exam e) {
		em.remove(em.merge(e));
		return true;
	}

	@Override
	public Boolean updateExam(Exam e) {
		em.merge(e);
		return true;
	}

	@Override
	public Exam findByIdExam(Integer id) {
		
		Exam e= em.find(Exam.class, id);
		if(e!=null)
		{
			return e;
		}
		return null;
	}

	@Override
	public Exam findLatesExam() {
		   Exam e=null;
		   Query query = em.createNativeQuery("select * from mooc.exam order by id DESC limit 0,1;", Exam.class);
		
		   e=(Exam) query.getSingleResult();
		   
		   return e;
				
	}

	@Override
	public List<Exam> findAllExam() {
		
	
	
			Query query=em.createQuery("select e from Exam e ");
			return query.getResultList();
		
	}

	







}
