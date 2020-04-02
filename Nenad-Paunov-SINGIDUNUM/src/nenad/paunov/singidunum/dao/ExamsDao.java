package nenad.paunov.singidunum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.Exam;

@Transactional
@Component
public class ExamsDao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams() {
		return session.getCurrentSession().createQuery("FROM Exam").list();
	}

	public Exam getExam(int id) {
		return session.getCurrentSession().get(Exam.class, id);
	}

	public Exam saveOrUpdateExam(Exam exam) {
		session.getCurrentSession().saveOrUpdate(exam);
		return exam;
	}

	public boolean deleteExam(int id) {
		try {
			session.getCurrentSession().delete(session.getCurrentSession().get(Exam.class, id));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
