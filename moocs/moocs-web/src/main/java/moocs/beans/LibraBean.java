package moocs.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.domain.Entity.Learner;
import edu.esprit.mooc.services.SessionBean.*;

@ManagedBean(name = "lib")
public class LibraBean {
	Course course= new Course();
	List<Course> found=null ;
	String namer ;
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	

	public List<Course> getFound() {
		return found;
	}

	public void setFound(List<Course> found) {
		this.found = found;
	}

	public String getNamer() {
		return namer;
	}

	public void setNamer(String namer) {
		this.namer = namer;
	}
	@EJB
	CourseEJBRemote Course_Service ;
	public String ShowCourse(){
		found=Course_Service.getCoursebyNamer(namer);
		if(found!=null)
		{    
			return "ResultLi";
			
		}
		else {
			
		return "SearchLi";
		
		}	
		}
	}
	
	
	
	
	
