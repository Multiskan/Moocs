package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.Respond;
import edu.esprit.mooc.domain.Entity.User;

@Remote
public interface GestionMessageSbRemote {
	
	public void persistMessage(Message message);
	public void updateMessage(Message message);
	
	public void removeMessage(Message message);
	public Message findMessageById(int id);
	public List<Message>getAllMessage(int id_reciever);
	public List<Message>getAllnumberMessage(int id_reciever);
	public List<Message>getAllsendMessage(int id_sender);
	public void RespondMessage(Message message,Respond res);
	



}
