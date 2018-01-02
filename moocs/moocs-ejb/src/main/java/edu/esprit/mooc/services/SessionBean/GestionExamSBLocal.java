package edu.esprit.mooc.services.SessionBean;


import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import edu.esprit.mooc.domain.Entity.Exam;


@LocalBean
public interface GestionExamSBLocal {
	public void persistExam(Exam e);
	public Boolean removeExam(Exam e);
	public Boolean updateExam(Exam e);
	public Exam findByIdExam(Integer id);
	public Exam findLatesExam();
	public List<Exam> findAllExam();
}
