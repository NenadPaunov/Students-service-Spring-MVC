package nenad.paunov.singidunum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.services.StudentsServices;

public class StudentsController {
	@Autowired
	private StudentsServices StudentsServices;

	@RequestMapping("/students")
	public String showPlayer(Model model) {
		List<Student> students = StudentsServices.getAllStudents();
		model.addAttribute("students",students);
		return "students";
		
	}
}
