package nenad.paunov.singidunum.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("students", students);
		return "students";
	}

	@RequestMapping("/create_student")
	public String createStudent(Model model) {
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities", cities);
		return "create_student";
	}

	@RequestMapping(value = "/docreatestudent", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Student student, City city, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "create_student";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}
		City newCity = citiesService.getCity(city.getCityId());
		student.setCity(newCity);
		studentsServices.saveOrUpdateStudent(student);
		model.addAttribute("student", student);
		return "student_created";
	}


	@RequestMapping(value ="/doupdatestudent/{id}")
	public String updateStudent(@PathVariable int id, Model model) {
		Student student = studentsServices.getStudent(id);
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities", cities);
		model.addAttribute("student", student);
		model.addAttribute("id", id);
		return "update_student";
	}
	
	@RequestMapping(value = "/updatestudent/{id}", method = RequestMethod.POST)
	public String doUpdate(@PathVariable int id, Model model, @Valid Student student, City city, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "update_student";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}
		City newCity = citiesService.getCity(city.getCityId());
		student.setCity(newCity);
		studentsServices.saveOrUpdateStudent(student);
		model.addAttribute("student", student);
		return "student_created";
	}
	
	@RequestMapping(value ="/dodeletestudent/{id}")
	public String deleteStudent(@PathVariable int id, Model model) {
		studentsServices.deleteStudent(id);
		List<Student> students = studentsServices.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}
	
	
}
