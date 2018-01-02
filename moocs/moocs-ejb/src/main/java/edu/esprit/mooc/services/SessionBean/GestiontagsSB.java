package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.domain.Entity.Tags;


/**
 * Session Bean implementation class GestiontagsSB
 */
@Stateless(name="tagssb")
@LocalBean
public class GestiontagsSB implements GestiontagsSBRemote {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public GestiontagsSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persistTags(Tags tags) {
		em.persist(tags);
		
	}

	@Override
	public void updateTags(Tags tags) {
		em.merge(tags);
		
	}

	@Override
	public void removetTags(Tags tags) {
		em.remove(em.merge(tags));
		
	}

	@Override
	public Tags findTagsById(int id) {

		Tags tags=em.find(Tags.class, id);
		if(tags != null)
		{
			return tags;
		}
		return null;
		
	}

	@Override
	public List<Tags> getAllCourseTag(String nom_tag) {
		String text="select u from Tags u where u.nomtag= :tag";
		Query query=em.createQuery(text).setParameter("tag", nom_tag);
		return query.getResultList();
	}
	
	

}
