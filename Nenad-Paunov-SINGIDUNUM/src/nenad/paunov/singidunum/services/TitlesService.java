package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.TitlesDao;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.entities.Title;

@Service
public class TitlesService {
	@Autowired
	TitlesDao titlesDao;

	public List<Title> getAllTitles() {
		return titlesDao.getAllTitles();
	}

	public Title getTitle(int id) {
		return titlesDao.getTitle(id);
	}

	public Title saveOrUpdateTitle(Title title) {
		return titlesDao.saveOrUpdateTitle(title);
	}

	public void deleteTitle(int id) {
		titlesDao.deleteTitle(id);
	}
	
	public  List<Title> getPaginated(int page, int number){
		return titlesDao.getPaginated(page, number);
	}
}
