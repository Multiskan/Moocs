package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Request
 *
 */
@Entity

public class Request implements Serializable {

	
	private Integer id_request;
	private User user;
	private String statut;
	private static final long serialVersionUID = 1L;

	public Request() {
		super();
	} 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId_request() {
		return this.id_request;
	}

	public void setId_request(Integer id_request) {
		this.id_request = id_request;
	}
	
	@ManyToOne
	@JoinColumn(name="id_User")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "id_request=" + id_request + ", user=" + user + ", statut=" + statut + "";
	}
	
	
   
}
