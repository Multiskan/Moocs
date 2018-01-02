package edu.esprit.mooc.services.SessionBean;





import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.Chapter;
import edu.esprit.mooc.domain.Entity.Course;

/**
 * Session Bean implementation class ChapterEJB
 */
@Stateless
public class ChapterEJB implements ChapterEJBRemote, ChapterEJBLocal {

    /**
     * Default constructor. 
     */
    public ChapterEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Boolean addChapter(Chapter chapter) {
        try {
            entityManager.persist(chapter);
            return true;
          
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Boolean deleteChapter(Chapter chapter) {
        try {
            entityManager.remove(entityManager.merge(chapter));
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
    
    @Override
    public Boolean updateChaptre(Chapter chapter) {
        try {
            entityManager.merge(chapter);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
   
   @Override 
   public List<Chapter> getchapterbyid(int id ) {

        Query query=entityManager.createQuery("select c from Chapter c where c.id =: p ");
        query.setParameter("p", id) ;
        return  query.getResultList();
    }
@Override
public List<Chapter> getAllChapters() {
	Query query=entityManager.createQuery("select c from Chapter c ");
    return  query.getResultList();
	
}
//@Override
//public List<Chapter> getChapterByName(String nomChap) {
//Query query=entityManager.createQuery("select c from Chapter c where c.course=:p ");
	// query.setParameter("p", course);
 //return  (Course)query.getSingleResult();
	//return null;
//}
@Override
public List<Chapter> getChapterByCourse(Course course) {
	Query query=entityManager.createQuery("select c from Chapter c where c.course=:p ");
	query.setParameter("p", course);
	return  query.getResultList();
	
}
@Override
public Chapter FindChapterByName(String nom) {
	Query query=entityManager.createQuery("select c from Chapter c where c.nom_chapter=:p ");
	query.setParameter("p", nom);
	return (Chapter)query.getSingleResult();
}




	

}
