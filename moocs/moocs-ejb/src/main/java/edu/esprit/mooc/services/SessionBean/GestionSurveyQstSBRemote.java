package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyQst;

@Remote
public interface GestionSurveyQstSBRemote {
	void persistSurveyQst(SurveyQst Qst);
	void removeSurveyQst(SurveyQst Qst);
	void updateSurveyQst(SurveyQst Qst);
	SurveyQst findByIdSurveyQst(Integer id);
	SurveyQst findLastQst();
     List<SurveyQst> findQuestionsByIdSurvey(Survey S);
     public List<SurveyQst> findAllQuestion() ;

}
