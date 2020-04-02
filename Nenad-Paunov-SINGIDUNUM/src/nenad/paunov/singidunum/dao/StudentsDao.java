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

	public Student getStudent(int id) {
		return session.getCurrentSession().get(Student.class, id);
	}

	public Student saveOrUpdateStudent(Student student) {
		session.getCurrentSession().saveOrUpdate(student);
		return student;
	}

	public boolean deleteStudent(int id) {
		try {
			session.getCurrentSession().delete(session.getCurrentSession().get(Student.class, id));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
