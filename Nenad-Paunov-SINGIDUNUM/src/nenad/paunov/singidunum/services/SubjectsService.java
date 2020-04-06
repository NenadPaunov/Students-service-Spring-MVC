package nenad.paunov.singidunum.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.dao.SubjectsDao;
import nenad.paunov.singidunum.entities.Exam;
import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.entities.Student;
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
	
	public void deleteSubject(int id) {
		 subjectsDao.deleteSubject(id);
	}
	
	public Set<Professor> getProfessorsBySubject(int id) {
		return subjectsDao.getSubject(id).getProfessor();	
	}
	
	public Set<Professor> getProfessorsBySubjectName(String name) {
		return subjectsDao.getSubjectByName(name).getProfessor();
	}
	
	public Subject getSubjectByName(String name) {
		return subjectsDao.getSubjectByName(name);
	}
	
	public Set<Student> getStudentsBySubject(int id) {
		return subjectsDao.getSubject(id).getStudents();
	}
	
	public  List<Subject> getPaginated(int page, int number){
		return subjectsDao.getPaginated(page, number);
	}
}
