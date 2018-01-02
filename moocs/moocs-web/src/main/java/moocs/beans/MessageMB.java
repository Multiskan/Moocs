package moocs.beans;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.GestionMessageSbRemote;
import edu.esprit.mooc.services.SessionBean.UserEJBRemote;







@ManagedBean
@ViewScoped
public class MessageMB {

	@EJB
	GestionMessageSbRemote gestionmessage;
	
	@EJB
	UserEJBRemote gestionuser;
	
	
	private String receiver;
	private String subject;
	private String contenue;
	private List<User> userList;
	
	private User user =new User();
	


	




	




	public List<User> getSubCategories()
	{
		return gestionuser.getAlluser();
	}

	
	
	
	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getContenue() {
		return contenue;
	}



	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	
	
	//User reciever=getProxy().findUserById(1);
	//User sender=getProxy().findUserById(2);

	public String Send() {
		Message m = new Message();
		m.setBody(contenue);
		m.setDate_Message(dateFormat.format(date));
		m.setState_Message(0);
		m.setSubject(subject);
		m.setSender(gestionuser.finduserById(user.getId_User()));
		m.setReceiver(gestionuser.finduserByName(receiver));
		//m.setReceiver(gestionuser.finduserById(1));
		//product.setCategory(service_catalog.findCategoryByName(category));
		//m.setReceiver(gestionuser.fin);
		//m.setReceiver(receiver);
		//m.setSender(sender);
		gestionmessage.persistMessage(m);
		return "inbox.xhtml";
		
	}


	
	






public String getReceiver() {
		return receiver;
	}




	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}




public List<User> getUserList() {
	return userList;
}



public void setUserList(List<User> userList) {
	this.userList = userList;
}




public User getUser() {
	return user;
}




public void setUser(User user) {
	this.user = user;
}




	
}
