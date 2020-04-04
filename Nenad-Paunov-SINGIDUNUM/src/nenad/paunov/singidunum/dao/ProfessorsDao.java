package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.Professor;

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
		session.getCurrentSession().delete(session.getCurrentSession().get(Professor.class, id));
	}

}
