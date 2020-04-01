package nenad.paunov.singidunum.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.StudentsDao;
import nenad.paunov.singidunum.entities.Student;

@Service
public class StudentsServices {
	@Autowired
	StudentsDao studentsDao;
	
	public List<Student> getAllStudents() {
		return studentsDao.getAllStudents();
	}
}
