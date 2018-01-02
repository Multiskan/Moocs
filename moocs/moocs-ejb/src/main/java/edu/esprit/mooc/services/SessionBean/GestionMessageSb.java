package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.Respond;
import edu.esprit.mooc.domain.Entity.User;

/**
 * Session Bean implementation class GestionMessageSb
 */
@Stateless(name="messagesb")
@LocalBean
public class GestionMessageSb implements GestionMessageSbRemote {
 
	
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionMessageSb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persistMessage(Message message) {
		em.persist(message);
	}

	@Override
	public void updateMessage(Message message) {
		em.merge(message);
		
	}

	@Override
	public void removeMessage(Message message) {
		em.remove(em.merge(message));
		
	}

	@Override
	public Message findMessageById(int id) {
		
		Message message=em.find(Message.class, id);
		if(message!=null)
		{
			return message;
		}
		return null;	
		
	}
	
	
	@Override
	public List<Message> getAllMessage(int id_reciever) {
		String text="select u from Message u where u.receiver.id= :id";
		Query query=em.createQuery(text).setParameter("id", id_reciever);
	return query.getResultList();
		
	}
	
	@Override
	public List<Message> getAllnumberMessage(int id_reciever) {
		String text="select u from Message u where u.receiver.id= :id and u.state_Message =0";
		Query query=em.createQuery(text).setParameter("id", id_reciever);
		return query.getResultList();
	}
	
	
	@Override
	public List<Message> getAllsendMessage(int id_sender) {
		String text="select u from Message u where u.sender.id= :id";
		Query query=em.createQuery(text).setParameter("id", id_sender);
		return query.getResultList();
	}

	@Override
	public void RespondMessage(Message message, Respond res) {
		res.setMessage(message);
        res.setState_Message(0);
        em.persist(res);
		
	}


}
