package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Exam;
import edu.esprit.mooc.domain.Entity.QuestionExam;


@Remote
public interface GestionQuestionSBRemote {

	public void persistQuestion(QuestionExam q);
	public Boolean removeQuestion(QuestionExam q);
	public Boolean updateQuestion(QuestionExam q);
	public QuestionExam findByIdQuestion(Integer id);
	public QuestionExam findLatesQuestion();
	public List<QuestionExam> findAllQuestion();
	public List<QuestionExam> findAllQuestionbyExamId(Exam exam);
}
