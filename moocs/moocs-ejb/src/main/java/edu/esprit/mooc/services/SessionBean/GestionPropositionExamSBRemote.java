package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.PropositionExam;

@Remote
public interface GestionPropositionExamSBRemote {
	public void persistPropositionExam(PropositionExam p);
	public Boolean removePropositionExam(PropositionExam p);
	public Boolean updatePropositionExam(PropositionExam p);
	public PropositionExam findByIdPropositionExam(Integer id);
	public PropositionExam findLatesPropositionExam();
	public List<PropositionExam> findAllPropositionExam();
}
