package nenad.paunov.singidunum.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.time.temporal.ChronoUnit;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nenad.paunov.singidunum.dao.ExamsDao;
import nenad.paunov.singidunum.entities.Exam;
import nenad.paunov.singidunum.entities.Student;

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
	public List<Exam> getExamsByDate(Date examDate, String examName) {
		Query<Exam> query = session.getCurrentSession()
				.createQuery("FROM Exam WHERE examName =:examName AND examDate >:examDate");
		query.setParameter("examName", examName);
		query.setParameter("examDate", examDate);
		List<Exam> exams = query.list();
		return exams;
	}

	public Exam getExamByName(String examName) {
		List<Exam> exams = examsDao.getExamsByName(examName);
		if(exams.isEmpty()) {
			Exam exam = new Exam();
			exam.setExamName("Empty date");
			return exam ;
		}
		if (exams.size() != 0) 
			exams.sort((o1, o2) -> o1.getExamDate().compareTo(o2.getExamDate()));
		return exams.get(0);
	}

	public boolean getRegisterExamDate(String examName) {
		List<Exam> exams = examsDao.getExamsByName(examName);
		if(exams.isEmpty()) {
			Exam exam = new Exam();
			exam.setExamName("Empty date");
			return false ;
		}
		int counter = 0;
		long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(),
				getExamByName(examName).getExamDate().toLocalDate());
		if (daysBetween < 7) {
			counter++;
		}

		if (counter == 0) {
			return false;
		}
		return true;

	}
	public  List<Exam> getPaginated(int page, int number){
		return examsDao.getPaginated(page, number);
	}
}
