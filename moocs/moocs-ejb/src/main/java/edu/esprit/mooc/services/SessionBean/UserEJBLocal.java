package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.LocalBean;

import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.domain.Entity.Request;

import edu.esprit.mooc.domain.Entity.User;

@LocalBean
public interface UserEJBLocal {
	public Boolean adduser(User user) ;
	 public Boolean deleteuser(User user);
	 public Boolean updateuser(User user);
	 public List<User> getAlluser();
	 public int countallusers();
	 public User finduserById(Integer iduser);
	 public List<User> getuserwithreqest();
	 public List<Request> getacceptedreqest();
	 public int countallrequests();
	 public int countacceptedreq();
	User authenticate(String nom_user, String mdp);
	public User finduserByName(String name);
	List<User> getAllUsers();
	

}
