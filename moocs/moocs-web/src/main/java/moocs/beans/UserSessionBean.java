package moocs.beans ;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.brickred.socialauth.*;
import org.brickred.socialauth.util.SocialAuthUtil;

@Named(value = "userSession")
@SessionScoped
public class UserSessionBean implements Serializable {
	String FACEBOOK_APP_ID = "YOUR_FB_ID";
	private static final Object FACEBOOK_APP_SECRET = null;
	private SocialAuthManager manager;
    private String            originalURL;
    private String            providerID;
    private Profile           profile;
    
    public UserSessionBean() {}
    
    public void socialConnect() throws Exception {
        // Put your keys and secrets from the providers here 
        Properties props = System.getProperties();
        props.put("graph.facebook.com.consumer_key", FACEBOOK_APP_ID);
        props.put("graph.facebook.com.consumer_secret", FACEBOOK_APP_SECRET);
        // Define your custom permission if needed
        props.put("graph.facebook.com.custom_permissions", "publish_stream,email,user_birthday,user_location,offline_access");
        
        // Initiate required components
        SocialAuthConfig config = SocialAuthConfig.getDefault();
        config.load(props);
        manager = new SocialAuthManager();
        manager.setSocialAuthConfig(config);
        
        // 'successURL' is the page you'll be redirected to on successful login
        ExternalContext externalContext   = FacesContext.getCurrentInstance().getExternalContext();
        String          successURL        = externalContext.getRequestContextPath() + "socialLoginSuccess.xhtml"; 
        String          authenticationURL = manager.getAuthenticationUrl(providerID, successURL);
        FacesContext.getCurrentInstance().getExternalContext().redirect(authenticationURL);
    }
    
    public void pullUserInfo() {
        try {
            // Pull user's data from the provider
            ExternalContext    externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request         = (HttpServletRequest) externalContext.getRequest();
            Map                map             = SocialAuthUtil.getRequestParametersMap(request);
            if (this.manager != null) {
                AuthProvider provider = manager.connect(map);
                this.profile          = provider.getUserProfile();
            
                // Do what you want with the data (e.g. persist to the database, etc.)
                System.out.println("User's Social profile: " + profile);
            
                // Redirect the user back to where they have been before logging in
                FacesContext.getCurrentInstance().getExternalContext().redirect(originalURL);
            
            } else FacesContext.getCurrentInstance().getExternalContext().redirect(externalContext.getRequestContextPath() + "home.xhtml");
        } catch (Exception ex) {
            System.out.println("UserSession - Exception: " + ex.toString());
        } 
    }
    
    public void logOut() {
        try {
            // Disconnect from the provider
            manager.disconnectProvider(providerID);
            
            // Invalidate session
            ExternalContext    externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request         = (HttpServletRequest) externalContext.getRequest();
           
            
            // Redirect to home page
            FacesContext.getCurrentInstance().getExternalContext().redirect(externalContext.getRequestContextPath() + "home.xhtml");
        } catch (IOException ex) {
            System.out.println("UserSessionBean - IOException: " + ex.toString());
        }
    }
    
    // Getters and Setters
}