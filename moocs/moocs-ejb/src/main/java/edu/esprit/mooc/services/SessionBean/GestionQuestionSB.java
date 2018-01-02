package edu.esprit.mooc.services.SessionBean;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.Exam;
import edu.esprit.mooc.domain.Entity.QuestionExam;


@Stateless(name="QuestionSB")
@LocalBean
public class GestionQuestionSB implements GestionQuestionSBRemote {

	@PersistenceContext
	EntityManager em;
	
	public GestionQuestionSB(){
		}
	
	@Override
	public void persistQuestion(QuestionExam q) {
		em.persist(q);
		
	}

	@Override
	public Boolean removeQuestion(QuestionExam q) {
		em.remove(em.merge(q));
		return true;
	}

	@Override
	public Boolean updateQuestion(QuestionExam q) {
		em.merge(q);
		return true;
	}

	@Override
	public QuestionExam findByIdQuestion(Integer id) {
		
		QuestionExam q= em.find(QuestionExam.class, id);
		if(q!=null)
		{
			return q;
		}
		return null;
	}

	@Override
	public QuestionExam findLatesQuestion() {
		   QuestionExam q=null;
		   Query query = em.createNativeQuery("select * from mooc.questionexam order by id DESC limit 0,1;", QuestionExam.class);
		
		   q=(QuestionExam) query.getSingleResult();
		   
		   return q;
				
	}

	@Override
	public List<QuestionExam> findAllQuestion() {
		
	
	
			Query query=em.createQuery("select q from QuestionExam q ");
			return query.getResultList();
		
	}
	
	@Override
	public List<QuestionExam> findAllQuestionbyExamId(Exam exam) {
		
	
	
			Query query=em.createQuery("select q from QuestionExam q where q.exam=:p ");
			query.setParameter("p", exam);
			return query.getResultList();
		
	}

	
	
}

