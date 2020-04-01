package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.Student;
@Component
@Transactional
public class StudentsDao {
	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		return session.getCurrentSession().createQuery("FROM Student").list();
	}
}
