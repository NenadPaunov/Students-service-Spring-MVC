package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.StudentsDao;
import nenad.paunov.singidunum.entities.Student;

@Service
public class StudentsService {
	@Autowired
	StudentsDao studentsDao;
	
	public List<Student> getAllStudents() {
		return studentsDao.getAllStudents();
	}
	
	public Student getStudent(int id) {
		return studentsDao.getStudent(id);
	}
	
	public Student saveOrUpdateStudent(Student student) {
		return studentsDao.saveOrUpdateStudent(student);
	}
	
	public void deleteStudent(int id) {
		 studentsDao.deleteStudent(id);
	}
	
	
}
