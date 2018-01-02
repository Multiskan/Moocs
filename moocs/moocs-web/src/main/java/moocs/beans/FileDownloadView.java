package moocs.beans;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import edu.esprit.mooc.domain.Entity.User;
 
@ManagedBean
@SessionScoped
public class FileDownloadView {
     
    private StreamedContent file;
    @ManagedProperty(value="#{auth}")
    private String filename;
    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public FileDownloadView() {        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/img/#{auth.filename}.jpeg");
        file = new DefaultStreamedContent(stream, "image/jpeg", "downloaded_optimus.jpeg");
    }
 
    public StreamedContent getFile() {
        return file;
    }
    
}