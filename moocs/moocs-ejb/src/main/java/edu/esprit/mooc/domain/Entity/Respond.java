package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Respond
 *
 */
@Entity

public class Respond implements Serializable {

	
	

	private Integer id_Respond;
	private String body;
	private String date_Message;
	private Integer state_Message;
	private Message message;
	
	
	private static final long serialVersionUID = 1L;

	public Respond() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId_Respond() {
		return id_Respond;
	}

	public void setId_Respond(Integer id_Respond) {
		this.id_Respond = id_Respond;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate_Message() {
		return date_Message;
	}

	public void setDate_Message(String date_Message) {
		this.date_Message = date_Message;
	}

	public Integer getState_Message() {
		return state_Message;
	}

	public void setState_Message(Integer state_Message) {
		this.state_Message = state_Message;
	}
	@ManyToOne
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
   
}
