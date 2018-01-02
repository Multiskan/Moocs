package org.primefaces.showcase.view.multimedia;

 
import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;

import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.UserEJBRemote;
import moocs.beans.AuthentiBean;

@ManagedBean(name="photoCamView")
@ViewScoped
public class PhotoCamView {
	
	private User user = new User();
   private String filename;
   public String imgsrc;
   public String newFileName ;
   @EJB
   UserEJBRemote user_service;
   public String getNewFileName() {
	return newFileName;
	
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
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

   public void oncapture(CaptureEvent captureEvent) {
      filename = getRandomImageName();

      byte[] data = captureEvent.getData();


      ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      //        String newFileName =" W:\\Projects\\learnTocode\\WebContent" + File.separator + "demo" + File.separator + "images" + File.separator + "photocam" + File.separator + filename + ".jpeg";
      newFileName = servletContext.getRealPath("")+ filename + ".jpeg";
      imgsrc=newFileName;
      FileImageOutputStream imageOutput;
      try {
         imageOutput = new FileImageOutputStream(new File(newFileName));
         imageOutput.write(data, 0, data.length);
         user.setPhoto(newFileName);
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
   
   public String upload (User user)
   {  User c = user_service.finduserById(user.getId_User());
      user.setId_User(c.getId_User());
	  user.setPhoto(newFileName);
	 user_service.updateuser(user);
	   return "null"; 
	   
	   
	   
	   
   }
}