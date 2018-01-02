package edu.esprit.mooc.domain.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: University
 *
 */
@Entity

public class University implements Serializable {

	private Integer id_University;
	private String University_Name;
	private String Photo ;
	
	private String pos ;
	
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	private static final long serialVersionUID = 1L;

	public University() {
		super();
	}
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	
	public Integer getId_University() {
		return id_University;
	}
	public void setId_University(Integer id_University) {
		this.id_University = id_University;
	}
	
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getUniversity_Name() {
		return University_Name;
	}
	public void setUniversity_Name(String university_Name) {
		University_Name = university_Name;
	}
	
	
	
	
}
