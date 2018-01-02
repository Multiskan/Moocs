package edu.esprit.mooc.services.SessionBean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.esprit.mooc.domain.Entity.Request;

import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.domain.Entity.User;

@Stateless
public class UserEJB implements UserEJBLocal,UserEJBRemote {
	
	
	@PersistenceContext
    private EntityManager entityManager;
	 
	 @Override
	    public Boolean adduser(User user) {
	        try {
	            entityManager.persist(user);
	            return true;
	          
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }

	    }

	    @Override
	    public Boolean deleteuser(User user) {
	        try {
	            entityManager.remove(entityManager.merge(user));
	            return true;

	        } catch (Exception e) {
	            return false;
	        }
	    }

	    @Override
	    public Boolean updateuser(User user) {
	        try {
	            entityManager.merge(user);
	            return true;

	        } catch (Exception e) {
	            return false;
	        }
	    }
	    @Override
	    public List<User> getAlluser() {
	    	return entityManager.createQuery("select u from User u", User.class)
	    				.getResultList();
	    	
	    }
	    
	    
	    @Override
	    public User finduserById(Integer iduser) {
	        User m=null;
	        try {
	            
	            m=entityManager.find(User.class, iduser);
	            
	            return m;

	        } catch (Exception e) {
	            System.out.println(""+e.getMessage());
	            return null;
	        }
	    }
	   
	    @Override
	    public int countallusers(){
	    	
	    	List<User> courses = getAlluser() ;
	    	int c = courses.size() ;
	    	return c ;
	    	
	    	
	    	
	    }
	    
	    @Override
	    public List<User> getuserwithreqest(){
	    	 Query query =entityManager.createQuery("select u from User u where u.requests IS NOT EMPTY ");
		       
	    	 return  query.getResultList();
	    	
	    }
	    
	    @Override
	    public List<Request> getacceptedreqest(){
	    	 Query query =entityManager.createQuery("select r from Request r where r.statut ='trainer_approved' ");
		       
	    	 return  query.getResultList();
	    	
	    }
	    @Override
	    public int countallrequests(){
	    	List<User> d = getuserwithreqest();
	    	return d.size();
	    }
	    @Override
	    public int countacceptedreq(){
	    	List<Request> d = getacceptedreqest();
	    	return d.size();
	    }
	    
	    @Override
		  public User authenticate(String nom_user, String mdp) {
				User found = null;
				String jpql = "select u from User u where u.nom_user=:nom_user and u.mdp=:mdp";
				TypedQuery<User> query =  entityManager.createQuery(jpql, User.class);
				query.setParameter("nom_user", nom_user);
				query.setParameter("mdp",mdp);
				try {
					found = query.getSingleResult();
				} catch (Exception ex) {
					Logger.getLogger(UserEJB.class.getName()).log(
							Level.WARNING,
							"authentication attempt failure with nom_user=" + nom_user
									+ " and mdp=" + mdp);
				}
				return found;
	  
	    

}
	    @Override
		public User finduserByName(String name) {
			User found = null;
			TypedQuery<User> query = entityManager.createQuery(
					"select c from User c where c.nom_user=:x", User.class);
			query.setParameter("x", name);
			try {
				found = query.getSingleResult();
			} catch (Exception ex) {
				Logger.getLogger(this.getClass().getName()).log(Level.INFO,
						"no category with name=" + name);
			}
			return found;}
	   
	    @Override
	    public List<User> getAllUsers() {

	        Query query=entityManager.createQuery("select c from User c ");
	        return  query.getResultList();
	    }
	    }
