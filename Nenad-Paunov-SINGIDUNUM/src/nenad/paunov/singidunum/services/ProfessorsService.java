package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.ProfessorsDao;
import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.entities.Student;

@Service
public class ProfessorsService {
	@Autowired
	ProfessorsDao professorsDao;

	public List<Professor> getAllProfessors() {
		return professorsDao.getAllProfessors();
	}

	public Professor getProfessor(int id) {
		return professorsDao.getProfessor(id);
	}

	public Professor saveOrUpdateProfessor(Professor professor) {
		return professorsDao.saveOrUpdateProfessor(professor);
	}

	public void deleteProfessor(int id) {
		professorsDao.deleteProfessor(id);
	}
	public  List<Professor> getPaginated(int page, int number){
		return professorsDao.getPaginated(page, number);
	}
}
