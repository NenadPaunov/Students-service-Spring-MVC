package nenad.paunov.singidunum.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nenad.paunov.singidunum.entities.City;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.services.CitiesService;
import nenad.paunov.singidunum.services.StudentsService;
@Controller
public class StudentsController {
	@Autowired
	private StudentsService studentsServices;
	@Autowired
	private CitiesService citiesService;

	@RequestMapping("/students")
	public String showStudents(Model model) {
		List<Student> students = studentsServices.getAllStudents();
		model.addAttribute("students",students);
		return "students";		
	}
	
	@RequestMapping("/createstudent")
	public String createStudent(Model model){	
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities",cities);
		return "createstudent";
	}
	@RequestMapping(value="/docreatestudent", method=RequestMethod.POST)
	public String doCreate(@RequestParam String category, Model model,@Valid Student student, BindingResult result, @ModelAttribute("myform") Student myform) { //obrisati requestparam
		if(result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError e: errors) {
				System.out.println(e.getDefaultMessage());
			return "teststudent"; //vratiti na createstudent
			}
		}else {
			System.out.println("Form validated successsfully!");
			
		}
		System.out.println(category);
		System.out.println(student);
		//System.out.println(student.getCity().getCityId());
		studentsServices.saveOrUpdateStudent(student);
		model.addAttribute("student",student);
		return "studentcreated";
	}
}
