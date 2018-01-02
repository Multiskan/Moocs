package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.mooc.domain.Entity.Chapter;

@Local
public interface ChapterEJBLocal {
	 public Boolean addChapter(Chapter chapter);
	 public Boolean deleteChapter(Chapter chapter);
	 public Boolean updateChaptre(Chapter chapter);
	 public List<Chapter> getchapterbyid(int id );

}
