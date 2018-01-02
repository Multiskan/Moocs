package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;


import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;

@Remote
public interface GestionSurveyPropositionSBRemote {
	void persistSurveyProposition(SurveyProposition prop);
	void removeSurveyProposition(SurveyProposition prop);
	void updateSurveyProposition(SurveyProposition prop);
	SurveyProposition findByIdSurveyProposition(Integer id);
	Integer ChartNbrePropbyQst();
	List<SurveyProposition> findPropositionByIDQuestion(SurveyQst Q);
	List<SurveyProposition> findAllProposition();

}
