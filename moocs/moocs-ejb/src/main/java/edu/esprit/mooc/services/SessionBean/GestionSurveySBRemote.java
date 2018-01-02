package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Survey;


@Remote
public interface GestionSurveySBRemote {
	
	void persistSurvey(Survey s);
	void removeSurvey(Survey s);
	void updateSurvey(Survey s);
	Survey findByIdSurvey(Integer id);
	Survey findLatesSurvey();
	List<Survey> findAllSurveys();

}
