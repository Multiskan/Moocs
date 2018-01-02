package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.Respond;

@Remote
public interface GestionRespondSbRemote {

	
	
	
	public void persistRespond(Respond respond);
	public void updateMessage(Respond respond);
	public void removeMessage(Respond respond);
	public Respond findRespondById(int id);
	public List<Message>getAllRespond(int id_message);
	public List<Message>getAllnumberRespond(int id_message);
	//public List<Message>getAllsendMessage(int id_sender);
	//public void RespondMessage(Message message,Respond res);
	
}
