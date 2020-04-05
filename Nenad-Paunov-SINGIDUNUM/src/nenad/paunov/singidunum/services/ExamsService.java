package nenad.paunov.singidunum.services;

import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.dao.ExamsDao;
import nenad.paunov.singidunum.entities.Exam;

@Service
@Transactional
public class ExamsService {
	@Autowired
	ExamsDao examsDao;
	@Autowired
	SessionFactory session;

	public List<Exam> getAllExams() {
		return examsDao.getAllExams();
	}

	public Exam getExam(int id) {
		return examsDao.getExam(id);
	}

	public Exam saveOrUpdateExam(Exam exam) {
		return examsDao.saveOrUpdateExam(exam);
	}

	public void deleteExam(int id) {
		examsDao.deleteExam(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Exam> getExamsByDate(Date examDate, String examName){
		System.out.println(examName);
		System.out.println(examDate);
		Query<Exam> query = session.getCurrentSession().createQuery("FROM Exam WHERE examName =:examName AND examDate >:examDate");
		query.setParameter("examName", examName);
		query.setParameter("examDate", examDate);
		List<Exam> exams = query.getResultList();
		return exams;
	}

}
