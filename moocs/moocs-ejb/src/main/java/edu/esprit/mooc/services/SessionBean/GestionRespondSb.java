package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.Respond;

/**
 * Session Bean implementation class GestionRespondSb
 */
@Stateless(name="respondsb")
@LocalBean
public class GestionRespondSb implements GestionRespondSbRemote {

	
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionRespondSb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persistRespond(Respond respond) {
		em.persist(respond);
		
	}

	@Override
	public void updateMessage(Respond respond) {
		em.merge(respond);
		
	}

	@Override
	public void removeMessage(Respond respond) {
		em.remove(em.merge(respond));
		
	}

	@Override
	public Respond findRespondById(int id) {
		Respond respond=em.find(Respond.class, id);
		if(respond!=null)
		{
			return respond;
		}
		return null;
	}

	//@Override
	//public List<Respond> getAllRespond(int id_message) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public List<Message> getAllnumberRespond(int id_message) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public void RespondMessage(Message message, Respond res) {
		res.setMessage(message);
        res.setState_Message(0);
        em.persist(res);
		
	}*/

	@Override
	public List<Message> getAllRespond(int id_message) {
		// TODO Auto-generated method stub
		return null;
	}

}
