package moocs.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Null;

import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.domain.Entity.Trainer;
import edu.esprit.mooc.services.SessionBean.CourseEJBRemote;
import edu.esprit.mooc.services.SessionBean.UserEJB;
import edu.esprit.mooc.services.SessionBean.UserEJBRemote;

@ManagedBean(name = "coursebean")
@javax.faces.bean.SessionScoped
public class CourseBean {
	
	
	private Course course = new Course() ;
	private int id ;
	private String course_name ;
	private int id_trainer ;
	private Date date10;
	private List<Course> listecour = null ;
	
public List<Course> getListecour() {
		return listecour;
	}


	public void setListecour(List<Course> listecour) {
		this.listecour = listecour;
	}


public Date getDate10() {
		return date10;
	}


	public void setDate10(Date date10) {
		this.date10 = date10;
	}


public int getId_trainer() {
		return id_trainer;
	}


	public void setId_trainer(int id_trainer) {
		this.id_trainer = id_trainer;
	}


public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


public CourseBean(){
		
	}


public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}

@EJB
CourseEJBRemote course_service ;
@EJB
UserEJBRemote user_service ;


public String addCourse(Course course){
	Trainer trainer = (Trainer)user_service.finduserById(id_trainer);
	course.setStatut("pending");
	course.setTrainer(trainer);
	course.setDate_debut(date10);
	if (course_service.addCourse(course))
	{FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Successful",  "votre ajout a étè effectué avec succes " ) );
    context.addMessage(null, new FacesMessage("details", course.getNom_course()+ " est ajouté a votre liste de cours  "+course.getTrainer().getNom_user()));}
	else{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("failed",  "erreur cours non enregistré" ) );
	}
	return null ;
}
public String deletecourse(String nom ){
	Course c = new Course();
	c= course_service.findCoursebyname(nom);
		if(course_service.deletecourse(c)) 
		{FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Successful",  "le cours a étè supprimé" ) );
	    context.addMessage(null, new FacesMessage("details",c.getNom_course()+ " est supprimé de  votre liste de cours  "+c.getTrainer().getNom_user()));}
		else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("failed",  "erreur " ) );
		}
	return null ;
}
public String updatecourse(Course course){
	Course c = new Course();
	c= course_service.findCoursebyname(course_name);
	course.setStatut(c.getStatut());
	course.setId_course(c.getId_course());
	course.setTrainer(c.getTrainer());
	course.setDate_debut(date10);
	
	if (course_service.updateCourse(course) )
	{FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Successful",  "le cours a étè modifié" ) );
    context.addMessage(null, new FacesMessage("details",course.getNom_course()+ " a été modifié  "+c.getTrainer().getNom_user()));}
	else{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("failed",  "erreur " ) );
	}
	return null ;
}
public String retour_page_principale_cours(){
	return "coursedashbord.xhtml?faces-redirect=true";
}

public String getallcourses(){
	listecour =course_service.getAllcourses();
	if (listecour!= null){
		return "affichagetout.xhtml?faces-redirect=true";
	}
	else {
		
	    return null ;
		
		
	}

}
public String redirecttoajout(){
	return "AjouterCourse.xhtml?faces-redirect=true";	
	
}
public String redirecttosupr(){
	return "DeleteCourse.xhtml?faces-redirect=true";	
	
}
public String redirecttohome(){
	return "login.xhtml?faces-redirect=true";	
	
}
public String redirecttochapter(){
	return "addChapter.xhtml?faces-redirect=true";
	
}
public String redirecttoaffichtout(){
	return "affichagetout.xhtml?faces-redirect=true";	
	
}

		
    




}
