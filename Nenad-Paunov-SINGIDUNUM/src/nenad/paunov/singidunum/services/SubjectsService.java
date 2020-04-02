package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.SubjectsDao;
import nenad.paunov.singidunum.entities.Subject;

@Service
public class SubjectsService {
	@Autowired
	SubjectsDao subjectsDao;
	
	public List<Subject> getAllSubjects() {
		return subjectsDao.getAllSubjects();
	}
	
	public Subject getSubject(int id) {
		return subjectsDao.getSubject(id);
	}
	
	public Subject saveOrUpdateSubject(Subject subject) {
		return subjectsDao.saveOrUpdateSubject(subject);
	}
	
	public boolean deleteSubject(int id) {
		return subjectsDao.deleteSubject(id);
	}
}
