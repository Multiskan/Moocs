package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.Tags;


@Remote
public interface GestiontagsSBRemote {
	
	
	
	public void persistTags(Tags tags);
	public void updateTags(Tags tags);
	public void removetTags(Tags tags);
	public Tags findTagsById(int id);
	public List<Tags>getAllCourseTag(String nom_tag);
	//public void send_messgae(User reciever,User sender,Message m);

}
