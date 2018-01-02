package edu.esprit.mooc.services.SessionBean;


import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Exam;

@Remote
public interface GestionExamSBRemote {
	public void persistExam(Exam e);
	public Boolean removeExam(Exam e);
	public Boolean updateExam(Exam e);
	public Exam findByIdExam(Integer id);
	public Exam findLatesExam();
	public List<Exam> findAllExam();
}
