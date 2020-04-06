package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.Exam;
import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.entities.Student;

@Transactional
@Component
public class ProfessorsDao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<Professor> getAllProfessors() {
		return session.getCurrentSession().createQuery("FROM Professor").list();
	}

	public Professor getProfessor(int id) {
		return session.getCurrentSession().get(Professor.class, id);
	}

	public Professor saveOrUpdateProfessor(Professor professor) {
		session.getCurrentSession().saveOrUpdate(professor);
		return professor;
	}

	public void deleteProfessor(int id) {
		for (Exam exam : getProfessor(id).getExams()) {
			exam.setProfessor(null);
		}
		session.getCurrentSession().delete(session.getCurrentSession().get(Professor.class, id));
	}

	 public List<Professor> getPaginated(int page, int number) {
	        Query<Professor> query = session.getCurrentSession().createQuery("from Professor", Professor.class);
	        query.setFirstResult((page - 1) * number);
	        query.setMaxResults(number);
	        return query.getResultList();
	    }
}
