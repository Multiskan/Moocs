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
import edu.esprit.mooc.domain.Entity.QuestionExam;
import edu.esprit.mooc.services.SessionBean.GestionExamSBRemote;
import edu.esprit.mooc.services.SessionBean.GestionQuestionSBRemote;

@ManagedBean
@Any
@ViewScoped
public class GestionQuestion implements Serializable {
	@EJB
	
	GestionQuestionSBRemote local;
	@EJB
	GestionExamSBRemote local1;
	Boolean form1;
	private Integer i=10;
	private List<QuestionExam> questexams = new ArrayList<QuestionExam>();
	private QuestionExam questexam = new QuestionExam();
	public Boolean getform1() {
		return form1;
	}
	public void setform1(Boolean form1) {
		this.form1 = form1;
	}
	public List<QuestionExam> getQuestexams() {
		return questexams;
	}
	public void setQuestexams(List<QuestionExam> questexams) {
		this.questexams = questexams;
	}
	public QuestionExam getQuestexam() {
		return questexam;
	}
	public void setQuestexam(QuestionExam questexam) {
		this.questexam = questexam;
	}
	
	@PostConstruct
	public void initquest(){
		form1=false;
		questexam=new QuestionExam();
		questexams=local.findAllQuestion();
	}
	
	
	public String doUpdatequest(){
		local.updateQuestion(questexam);
		
		initquest();
		return null;
	}
	
	public String doDeletequest(QuestionExam questexam){
		local.removeQuestion(questexam);
		initquest();
		return null;
	}
	
	public String initialiserquestion(){
		form1=true;
		questexam=new QuestionExam();
		//local.persistExam(exam);
		return null;
	}
	
	public List<QuestionExam> getAllQuestionExam(Integer id_Integer ){
		Exam exam;
		QuestionExam questionExam;
		exam=local1.findByIdExam(id_Integer);
		questexams=local.findAllQuestionbyExamId(exam);
		return questexams;
	}
	public Integer getI() {
		return i;
	}
	public void setI(Integer i) {
		this.i = i;
	}
	
}
