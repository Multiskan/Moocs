package moocs.beans;
import java.awt.List;
import java.io.Serializable;
import org.primefaces.context.RequestContext;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.UserEJBRemote;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean
@ViewScoped

public class ChatView implements Serializable {
     
    //private final PushContext pushContext = PushContextFactory.getDefault().getPushContext();
 
    /**
	 * 
	 */
	

 
    @ManagedProperty("#{auth.user}")
    private User user;
     
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String privateMessage;
   
    private String globalMessage;
     
    private String username;
     
    private boolean loggedIn;
     
    private String privateUser;
     
    private final static String CHANNEL = "/{room}/";
 
   java.util.List<User> listeuser=null ;
     
    public java.util.List<User> getListeuser() {
	return listeuser;
}

public void setListeuser(java.util.List<User> listeuser) {
	this.listeuser = listeuser;
}

	public String getPrivateUser() {
        return privateUser;
    }
 
    public void setPrivateUser(String privateUser) {
        this.privateUser = privateUser;
    }
 
    public String getGlobalMessage() {
        return globalMessage;
    }
 
    public void setGlobalMessage(String globalMessage) {
        this.globalMessage = globalMessage;
    }
 
    public String getPrivateMessage() {
        return privateMessage;
    }
 
    public void setPrivateMessage(String privateMessage) {
        this.privateMessage = privateMessage;
    }
     
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
   
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
 
    public void sendGlobal() {
    	 EventBus eventBus = EventBusFactory.getDefault().eventBus();

        eventBus.publish(CHANNEL + "*", username + ": " + globalMessage);
         
        globalMessage = null;
    }
     
    public void sendPrivate(String randy) {
    	 EventBus eventBus = EventBusFactory.getDefault().eventBus();
    eventBus.publish(CHANNEL + privateUser, "[PM] " + randy + ": " + privateMessage);
          
        privateMessage = null;
    }
    @EJB
    UserEJBRemote user_service; 
    public void login() {
    	User found=null;
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        
            
           
           found=user_service.finduserByName(user.getNom_user());
           if(found!=null)
           {
           	user=found;
           	requestContext.execute("PF('subscriber').connect('/" + user.getNom_user() + "')");
            loggedIn = true;
            listeuser=user_service.getAlluser();
        }
        
    }
    
    
     
    public void disconnect() {
       
       
        loggedIn = false;
        
    }
}