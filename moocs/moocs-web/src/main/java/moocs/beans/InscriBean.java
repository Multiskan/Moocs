package moocs.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import edu.esprit.mooc.domain.Entity.Learner;
import edu.esprit.mooc.domain.Entity.Trainer;
import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.UserEJBRemote;

@ManagedBean(name = "inscri")
public class InscriBean {
	Learner learner= new Learner();
	
	
	
	
	public Learner getLearner() {
		return learner;
	}
	public void setLearner(Learner learner) {
		this.learner = learner;
	}
	@EJB
	UserEJBRemote user_service;
	public String inscript(){

		
		
		
		
			
		user_service.adduser(learner)	;
		
		
			
			return "signup";
			
		}
}
