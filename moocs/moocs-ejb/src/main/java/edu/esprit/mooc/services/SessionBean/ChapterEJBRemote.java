package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Chapter;
import edu.esprit.mooc.domain.Entity.Course;

@Remote
public interface ChapterEJBRemote {
	 public Boolean addChapter(Chapter chapter);
	 public Boolean deleteChapter(Chapter chapter);
	 public Boolean updateChaptre(Chapter chapter);
	 public List<Chapter> getAllChapters(); 
	 public List<Chapter> getchapterbyid(int id );
	 public List<Chapter> getChapterByCourse(Course course );
	 public Chapter FindChapterByName(String nom);

}
