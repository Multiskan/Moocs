package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import edu.esprit.mooc.domain.Entity.Course;


@Stateless
public class CourseEJB implements CourseEJBLocal,CourseEJBRemote {

	
	
	@PersistenceContext
    private EntityManager entityManager;


    public CourseEJB() {

    }
    @Override
    public Boolean addCourse(Course course) {
        try {
            entityManager.persist(course);
            return true;
          
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean deletecourse(Course course) {
        try {
            entityManager.remove(entityManager.merge(course));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateCourse(Course course) {
        try {
        	
            entityManager.merge(course);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Course> getAllcourses() {

        Query query=entityManager.createQuery("select c from Course c ");
        return  query.getResultList();
    }
   
    @Override
    public List<Course> getpendingcourses(){
    	
    	 Query query=entityManager.createQuery("select c from Course c where c.statut='pending' ");
         return  query.getResultList();
    	
    	
    	
    }
    
    @Override
    public int countpendingcourses(){
    	
    	List<Course> courses = getpendingcourses() ;
    	int c = courses.size() ;
    	return c ;
    	
    	
    	
    }
    @Override
    public int countacceptedcourses(){
    	
    	List<Course> courses = getacceptedcourses() ;
    	int c = courses.size() ;
    	return c ;
    	
    	
    	
    }
    @Override
    public int countrefusedcourses(){
    	
    	List<Course> courses = getrefusedcourses() ;
    	int c = courses.size() ;
    	return c ;
    	
    	
    	
    }
    @Override
    public int countalldcourses(){
    	
    	List<Course> courses = getAllcourses() ;
    	int c = courses.size() ;
    	return c ;
    	
    	
    	
    }
    
    @Override
    public List<Course> getacceptedcourses(){
    	
    	 Query query=entityManager.createQuery("select c from Course c where c.statut='accepted' ");
         return  query.getResultList();
    	
    	
    	
    }
    @Override
    public List<Course> getrefusedcourses(){
    	
    	 Query query=entityManager.createQuery("select c from Course c where c.statut='refused' ");
         return  query.getResultList();
    	
    	
    	
    }

    @Override
    public Course findCourseById(Integer idCourse) {
        Course j,m=null;
        try {
            
            m=entityManager.find(Course.class,idCourse);
            
            return m;

        } catch (Exception e) {
            System.out.println(""+e.getMessage());
            return null;
        }
    }@Override
    public Course findCoursebyname(String nomCourse){
    	 Query query=entityManager.createQuery("select c from Course c where c.nom_course=:p ");
    	 query.setParameter("p", nomCourse);
         return  (Course)query.getSingleResult();
    	
    	
    }
    @Override
    public List<Course> getCoursebyNamer(String namer) {
    	TypedQuery<Course> query = entityManager.createQuery("SELECT p from Course p WHERE p.nom_course LIKE '%"+namer+"%'", Course.class);
    	return query.getResultList();
        }
   
    
}
