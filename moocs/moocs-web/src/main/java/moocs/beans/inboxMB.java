package moocs.beans;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.services.SessionBean.GestionMessageSbRemote;

@ManagedBean(name="inboxBean")
@SessionScoped
public class inboxMB {
	
	@EJB
	GestionMessageSbRemote gestionmessage;
	
	
	private List<Message> messageList = new ArrayList<Message>();
	private Message message = new Message();
	
	
	
	public List<Message> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

	
	
	/**
	 * This function loads the customers.
	 */
	public void loadmessage() {
		this.messageList = gestionmessage.getAllMessage(1);
	}
	
	public void loadsentmessage() {
		this.messageList = gestionmessage.getAllsendMessage(1);
	}
	
	/**
	 * Finds the customer by id.
	 */
	public void findmessage() {
		this.message=gestionmessage.findMessageById(this.message.getId_Message());
	}
	
	public int vu(){
		message.setState_Message(1);
		gestionmessage.updateMessage(message);
		return message.getId_Message();
	}
	
	/**
	 * Clears the current customer bean
	 */
	public void clearmessage() {
		this.message = new Message();
	}
	
	/**
	 * This method calls deleteCustomer method of CustomerEjb
	 * to delete the Customer Entity
	 * @param customer
	 * @return index to navigate to index.xhtml
	 */
	public String deletemessage(Message message) {
		
		try {
			gestionmessage.removeMessage(message);
			MessageUtil.addSuccessMessage("Post was successfully deleted.");
		} catch (Exception e) {
			MessageUtil.addErrorMessage("Could not delete Customer.");
		}
	    
	    return "inbox";
	}
	
	
	/**
	 * 
	 * @return view to navigate to view.xhtml page
	 */
	public String updatemessage() {
		try {
			gestionmessage.updateMessage(this.message);
			MessageUtil.addSuccessMessage("message with id " + this.message.getId_Message() + " was successfully updated.");
			
		} catch (Exception e) {
			MessageUtil.addErrorMessage("message with id " + this.message.getId_Message() + " could not be saved. An update error occured.");
		}
		
		return "inbox";
	}
	
	
}
