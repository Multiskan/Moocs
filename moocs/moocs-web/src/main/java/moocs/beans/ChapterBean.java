package moocs.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.esprit.mooc.domain.Entity.Chapter;
import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.services.SessionBean.ChapterEJBRemote;
import edu.esprit.mooc.services.SessionBean.CourseEJBRemote;

@ManagedBean(name = "ChapterBean")
@SessionScoped
public class ChapterBean {
	
	
	private String nom;
	private String pdf;
	private String video;
    private Integer id;
    private String nomCourse ;
    
    private Chapter chap = new Chapter();
    private String nomChapmod;
	
    
    
	public Chapter getChap() {
		return chap;
	}

	public void setChap(Chapter chap) {
		this.chap = chap;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	 public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	@EJB
	CourseEJBRemote course_service ;

	
	@EJB
	ChapterEJBRemote chap_ejb ;
	
	public ChapterBean(){}
	
	public String getNomCourse() {
		return nomCourse;
	}

	public void setNomCourse(String nomCourse) {
		this.nomCourse = nomCourse;
	}
//addChapter
	public String addChap(){
	   
		Chapter chap=new Chapter();
		
		chap.setNom_chapter(nom);
		chap.setPdf(pdf);
		chap.setVideo(video);
	 Course course=new Course(); 
		course=course_service.findCourseById(id);
		
	
		chap.setCourse(course); 
		if(chap_ejb.addChapter(chap))
		{FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Successful",  "le chapitre a étè ajouté" ) );
	    }
		else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("failed",  "erreur " ) );
		}
		return null ;
	}
	
	
//affichAllChapter
	public List<Chapter> getAllchapter(){
		return chap_ejb.getAllChapters();
		
	}	

//affichChapterparcours
	public List<Chapter> getAllchapterOfcourse( String nomCours){
	    nomCourse=nomCours ;
		Course course;
	 //nomCourse="java";
	 course=course_service.findCoursebyname(nomCourse);
 	 return chap_ejb.getChapterByCourse(course);
	}

//redirection
 public String affichChapters(){
	 return "AffichChapter.xhtml?faces-redirect=true";
 }
 //deleteChap
  public String deleteChap(Chapter chap){	
	  chap_ejb.deleteChapter(chap);
	  
	  return "AffichChapter.xhtml?faces-redirect=true";
  }
//update
  public String redirection(){
	 
	  return "updateChap.xhtml?faces-redirect=true";
  }
  public String updateChap(){
	  Chapter chapmodi=chap_ejb.FindChapterByName(nomChapmod);
	  chap.setId(chapmodi.getId());
	  
	  Course course=new Course(); 
	  course=course_service.findCourseById(id);
		
	
	  chap.setCourse(course); 
//	  
	  if(chap_ejb.updateChaptre(chap))
	  {FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Successful",  "le chapitre a étè modifié" ) );
	    }
		else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("failed",  "erreur " ) );
		}
		return null ;
	 
  }

public String getNomChapmod() {
	return nomChapmod;
}

public void setNomChapmod(String nomChapmod) {
	this.nomChapmod = nomChapmod;
}
  
}
