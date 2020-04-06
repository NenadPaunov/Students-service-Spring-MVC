package nenad.paunov.singidunum.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.entities.Exam;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.entities.Subject;

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

	public void deleteExam(int id) {
			session.getCurrentSession().delete(session.getCurrentSession().get(Exam.class, id));
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getExamsByName(String examName) {
		return session.getCurrentSession().createQuery("FROM Exam WHERE examName=:examName AND examDate>:examDate")
				.setParameter("examName", examName)
				.setParameter("examDate", java.sql.Date.valueOf(LocalDate.now()))
				.list();
		
	}
	 public List<Exam> getPaginated(int page, int number) {
	        Query<Exam> query = session.getCurrentSession().createQuery("from Exam", Exam.class);
	        query.setFirstResult((page - 1) * number);
	        query.setMaxResults(number);
	        return query.getResultList();
	    }
	
}
