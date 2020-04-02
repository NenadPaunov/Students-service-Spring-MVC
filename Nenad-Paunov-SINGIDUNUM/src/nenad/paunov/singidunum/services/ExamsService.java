package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.ExamsDao;
import nenad.paunov.singidunum.entities.Exam;

@Service
public class ExamsService {
	@Autowired
	ExamsDao examsDao;
	
	public List<Exam> getAllExams() {
		return examsDao.getAllExams();
	}
	
	public Exam getExam(int id) {
		return examsDao.getExam(id);
	}
	
	public Exam saveOrUpdateExam(Exam exam) {
		return examsDao.saveOrUpdateExam(exam);
	}
	
	public boolean deleteExam(int id) {
		return examsDao.deleteExam(id);
	}
}
