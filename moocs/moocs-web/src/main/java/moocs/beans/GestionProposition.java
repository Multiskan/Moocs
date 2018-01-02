package moocs.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Any;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import edu.esprit.mooc.domain.Entity.Exam;
import edu.esprit.mooc.domain.Entity.PropositionExam;
import edu.esprit.mooc.services.SessionBean.GestionExamSBLocal;
import edu.esprit.mooc.services.SessionBean.GestionExamSBRemote;
import edu.esprit.mooc.services.SessionBean.GestionPropositionExamSBRemote;

@ManagedBean
@Any
@ViewScoped
public class GestionProposition implements Serializable{
	@EJB
	
	GestionPropositionExamSBRemote local;
	Boolean form2;
	private List<PropositionExam> propexams = new ArrayList<PropositionExam>();
	private PropositionExam propexam = new PropositionExam();
	public Boolean getform2() {
		return form2;
	}
	public void setform2(Boolean form2) {
		this.form2 = form2;
	}
	public List<PropositionExam> getPropexams() {
		return propexams;
	}
	public void setPropexams(List<PropositionExam> propexams) {
		this.propexams = propexams;
	}
	public PropositionExam getPropexam() {
		return propexam;
	}
	public void setPropexam(PropositionExam propexam) {
		this.propexam = propexam;
	}
	@PostConstruct
	public void initprop(){
		form2=false;
		propexam=new PropositionExam();
		propexams=local.findAllPropositionExam();
	}
	
	public String doUpdateproposition(){
		local.updatePropositionExam(propexam);
		initprop();
		return null;
	}
	
	public String doDeleteProposition(PropositionExam propexam){
		local.removePropositionExam(propexam);
		
		initprop();
		return null;
	}
	
	public String initialiserProposition(){
		form2=true;
		propexam=new PropositionExam();
		//local.persistExam(exam);
		return null;
	}
	
	
	
	
	
	
	
	
	
}
