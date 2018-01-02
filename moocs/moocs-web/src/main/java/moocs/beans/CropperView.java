package moocs.beans;


import java.io.File;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import org.primefaces.model.CroppedImage;

import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.UserEJBRemote;
 
@ManagedBean(name = "cropp")
@SessionScoped
public class CropperView {
	private String newImage ;
	private String newFileName ;
	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public String getNewImage() {
		return newImage;
	}

	public void setNewImage(String newImage) {
		this.newImage = newImage;
	}
	@ManagedProperty(value="#{auth.user}")
	private User user= new User();
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private CroppedImage croppedImage;
     
    private String newImageName;
 
    public CroppedImage getCroppedImage() {
        return croppedImage;
    }
 
    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }
    @EJB
    UserEJBRemote user_service;
    public void crop() {
        if(croppedImage == null) {
            return;
        }
         
        setNewImageName(getRandomImageName());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
         String newFileName = externalContext.getRealPath("")+ File.separator + "resources" + File.separator + "img"  + File.separator + getNewImageName() + ".jpeg";
         newImage=newFileName;
         System.out.print(newImage);
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(croppedImage.getBytes(), 0, croppedImage.getBytes().length);
            imageOutput.close();
            
            
            
          
      	   
            } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cropping failed."));
            return;
        }
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Cropping finished."));
    }
     
    private String getRandomImageName() {
        int i = (int) (Math.random() * 100000);
         
        return String.valueOf(i);
    }
     
    public String getNewImageName() {
        return newImageName;
    }
 
    public void setNewImageName(String newImageName) {
        this.newImageName = newImageName;
    }
    public String upload (){
    
     
      
    
	   user.setPhoto(newImage);
	   user_service.updateuser(user);
	   return "Profile" ;

    
    }
    }