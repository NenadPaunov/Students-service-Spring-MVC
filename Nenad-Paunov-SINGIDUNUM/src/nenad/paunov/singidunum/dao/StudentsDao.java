package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nenad.paunov.singidunum.entities.Student;
@Component
public class StudentsDao {
	@Autowired
	SessionFactory session;
	
	public List<Student> getAllStudents() {
		return session.getCurrentSession().createQuery("from Student").list();
	}
}
