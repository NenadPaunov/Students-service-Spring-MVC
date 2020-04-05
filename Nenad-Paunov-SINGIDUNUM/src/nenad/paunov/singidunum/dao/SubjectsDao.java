package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.Subject;

@Transactional
@Component
public class SubjectsDao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubjects() {
		return session.getCurrentSession().createQuery("FROM Subject").list();
	}

	public Subject getSubject(int id) {
		return session.getCurrentSession().get(Subject.class, id);
	}

	public Subject saveOrUpdateSubject(Subject subject) {
		session.getCurrentSession().saveOrUpdate(subject);
		return subject;
	}

	public void deleteSubject(int id) {
			session.getCurrentSession().delete(session.getCurrentSession().get(Subject.class, id));
	}
	
	public Subject getSubjectByName(String name) {
		return (Subject) session.getCurrentSession().createQuery("FROM Subject WHERE name=:name").setParameter("name", name).uniqueResult();
		
	}
}
