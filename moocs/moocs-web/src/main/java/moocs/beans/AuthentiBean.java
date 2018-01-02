package moocs.beans;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.event.CaptureEvent;
import org.primefaces.model.StreamedContent;

import edu.esprit.mooc.services.SessionBean.UserEJB;

import edu.esprit.mooc.services.SessionBean.UserEJBRemote;
import edu.esprit.mooc.domain.Entity.*;
@ManagedBean(name = "auth")
@SessionScoped
public class AuthentiBean {
	private StreamedContent file;
	private User user= new User();
	private String filename;
	   public String imgsrc;
	   public String newFileName ;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
public void setFilename(String filename) {
		this.filename = filename;
	}
@EJB
UserEJBRemote user_service;
public String authenticate(){

User found=null;
found=user_service.authenticate(user.getNom_user(),user.getMdp());
if(found!=null)
{
	user=found;
	return "firstv";
}
else{
	
	return "login";
}
		
}
public String getNewFileName() {
	return newFileName;
	
}



public void setNewFileName(String newFileName) {
	this.newFileName = newFileName;
}

private String getRandomImageName() {
      int i = (int) (Math.random() * 10000000);

      return String.valueOf(i);
   }

   public String getFilename() {
      return filename;
   }

   @SuppressWarnings("resource")
public void oncapture(CaptureEvent captureEvent) {
      filename = getRandomImageName();

      byte[] data = captureEvent.getData();


      ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      //        String newFileName =" W:\\Projects\\learnTocode\\WebContent" + File.separator + "demo" + File.separator + "images" + File.separator + "photocam" + File.separator + filename + ".jpeg";
      String newFileName = servletContext.getRealPath("")+ File.separator + "resources" + File.separator + "img"  + File.separator + filename + ".jpeg";
      imgsrc=newFileName;
      FileImageOutputStream imageOutput;
      try {
         imageOutput = new FileImageOutputStream(new File(newFileName));
         imageOutput.write(data, 0, data.length);
         
      }
      catch(IOException e) {
         throw new FacesException(e);
      }
   }

   public String getImgsrc() {
      return imgsrc;
   }

   public void setImgsrc(String imgsrc) {
      this.imgsrc = imgsrc;
   }
   
   public String upload ()
   {  User c = user_service.finduserById(user.getId_User());
      user.setId_User(c.getId_User());
	  user.setPhoto(imgsrc);
	 user_service.updateuser(user);
	   return "Profile"; 
	 }
   public String View(){
	   
	   return newFileName ;
   }
   public String ViewPhoto(String s)
   { 
	   return user.getPhoto();
   }
   public StreamedContent getFile() {
	   InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/img/filename.jpeg");
       file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
  
	   return file;
   }
}
