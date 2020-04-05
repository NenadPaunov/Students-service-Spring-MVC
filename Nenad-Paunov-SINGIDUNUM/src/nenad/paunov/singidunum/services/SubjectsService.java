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
import nenad.paunov.singidunum.entities.Subject;

@Service
@Transactional
public class SubjectsService {
	@Autowired
	SubjectsDao subjectsDao;
	@Autowired
	SessionFactory session;
	
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
	
//	@SuppressWarnings("unchecked")
//	public List<Professor> getProfessorsBySubject(int subjectId){
//		System.out.println("*"+subjectId+"*");
//		Query<Professor> query = session.getCurrentSession().createQuery("FROM ProfessorsSubjects WHERE subjectId=:subjectId");
//		query.setParameter("subjectId", subjectId);
//		List<Professor> professorsSubjects = query.getResultList();
//		System.out.println(professorsSubjects.size());
//		//List<Professor> professors = new ArrayList<Professor>();
//		return professorsSubjects;
//	}
	
	public Set<Professor> getProfessorsBySubject(int id) {
		return subjectsDao.getSubject(id).getProfessor();
		
	
	}
}
