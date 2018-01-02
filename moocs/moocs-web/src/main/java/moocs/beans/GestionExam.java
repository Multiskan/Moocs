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
import edu.esprit.mooc.services.SessionBean.GestionExamSBLocal;
import edu.esprit.mooc.services.SessionBean.GestionExamSBRemote;

@ManagedBean
@Any
@ViewScoped
public class GestionExam implements Serializable{
	@EJB
	
	GestionExamSBRemote local;
	Boolean form;
	private List<Exam> exams = new ArrayList<Exam>();
	private Exam exam = new Exam();
	
	
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	
	public Boolean getForm() {
		return form;
	}
	public void setForm(Boolean from) {
		this.form = from;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	@PostConstruct
	public void init(){
		form=false;
		exam=new Exam();
		exams=local.findAllExam();
	}
	
	public String doUpdate(){
		local.updateExam(exam);
		init();
		return null;
	}
	
	public String doDeleteExam(Exam exam){
		local.removeExam(exam);
		init();
		return null;
	}
	
	public String initialiser(){
		form=true;
		exam=new Exam();
		//local.persistExam(exam);
		return null;
	}
	
	
	
	
	
	
	
}
