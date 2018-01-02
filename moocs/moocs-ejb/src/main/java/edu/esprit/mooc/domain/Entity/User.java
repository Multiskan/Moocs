package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@DiscriminatorColumn(name="role")
public class User implements Serializable {

	
	private Integer id_User;
	private String nom_user;
	private String prenom_user;
	private String photo;
	private String email;
	private String mdp;
	private String resume;
	private Integer nbre_vote;
	
	private List<Message> list_Received_message=new ArrayList<Message>();
	private List<Message> list_sent_message=new ArrayList<Message>();

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId_User() {
		return this.id_User;
	}

	public void setId_User(Integer id_User) {
		this.id_User = id_User;
	}   
	public String getNom_user() {
		return this.nom_user;
	}

	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}   
	public String getPrenom_user() {
		return this.prenom_user;
	}

	public void setPrenom_user(String prenom_user) {
		this.prenom_user = prenom_user;
	}   
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}   
	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}   
	public Integer getNbre_vote() {
		return this.nbre_vote;
	}

	public void setNbre_vote(Integer nbre_vote) {
		this.nbre_vote = nbre_vote;
	}
	@OneToMany(mappedBy="sender")
	public List<Message> getList_Received_message() {
		return list_Received_message;
	}
	public void setList_Received_message(List<Message> list_Received_message) {
		this.list_Received_message = list_Received_message;
	}
	
	@OneToMany(mappedBy="receiver")
	public List<Message> getList_sent_message() {
		return list_sent_message;
	}
	public void setList_sent_message(List<Message> list_sent_message) {
		this.list_sent_message = list_sent_message;
	}
	
	

	
	

	
   
}
