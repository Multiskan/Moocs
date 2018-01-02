package moocs.beans;

import java.util.List;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.esprit.mooc.domain.Entity.University;

import edu.esprit.mooc.services.SessionBean.UniversityEJBRemote;

@ManagedBean(name = "univer")

public class UniversityBean {
University university = new University() ;
List<University> found=null ;
public University getUniversity() {
	return university;
}
public void setUniversity(University university) {
	this.university = university;
}
public List<University> getFound() {
	return found;
}
public void setFound(List<University> found) {
	this.found = found;
}
@EJB
UniversityEJBRemote University_Service ;
public String ShowUniversity(){
	found=University_Service.getAllUniversity();
	if(found!=null)
	{    
		return "Fb" ;
		
	}
	else {
		
	return "null";
}
}}