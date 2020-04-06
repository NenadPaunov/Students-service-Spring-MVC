package nenad.paunov.singidunum.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
import nenad.paunov.singidunum.entities.Exam;
import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.entities.Subject;
import nenad.paunov.singidunum.services.CitiesService;
import nenad.paunov.singidunum.services.ExamsService;
import nenad.paunov.singidunum.services.StudentsService;
import nenad.paunov.singidunum.services.SubjectsService;

@Controller
public class StudentsController {
	@Autowired
	private StudentsService studentsServices;
	@Autowired
	private CitiesService citiesService;
	@Autowired
	private SubjectsService subjectsServices;

	@RequestMapping("/students")
	public String showStudents(Model model) {
		List<Student> students = studentsServices.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}

	@RequestMapping("/student_details/{id}")
	public String showStudentDetails(@PathVariable int id, Model model) {
		Student student = studentsServices.getStudent(id);
		Set<Subject> subjects = student.getSubjects();
		model.addAttribute("subjects", subjects);
		Set<Exam> exams = student.getExams();
		model.addAttribute("exams", exams);
		model.addAttribute("student", student);
		return "student_details";
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

	@RequestMapping(value = "/doupdatestudent/{id}")
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

	@RequestMapping(value = "/doaddsubject/{id}")
	public String doAddSubject(@PathVariable int id, Model model) {
		Student student = studentsServices.getStudent(id);
		// Proci kroz listu i dodati samo one subjekte koji nisu isti po imenu
		//
		List<Subject> allSubjects = subjectsServices.getAllSubjects();
		Set<Subject> convertedSubjects = allSubjects.stream().collect(Collectors.toSet());
		Set<Subject> studentsSubjects = student.getSubjects();
		System.out.println(studentsSubjects.toString());
		System.out.println(studentsSubjects.size());

		convertedSubjects.removeAll(studentsSubjects);
		System.out.println(convertedSubjects.size());
		System.out.println(convertedSubjects.toString());

		model.addAttribute("subjects", convertedSubjects);
		model.addAttribute("student", student);
		model.addAttribute("id", id);
		return "student_add_subjects";
	}

	@RequestMapping(value = "/addsubject/{id}", method = RequestMethod.POST)
	public String addSubject(@PathVariable int id, @RequestParam ArrayList<Integer> list, Model model) {
		System.out.println("Dodavanje subjekata");
		Student student = studentsServices.getStudent(id);
		Set<Subject> subjects = new HashSet<Subject>();
		//Adding new subjects
		for (Integer sujbsId : list) {
			Subject newSubject = subjectsServices.getSubject(sujbsId);
			subjects.add(newSubject);
		}
		//Adding previously added subjects
		Set<Subject> studentsSubjects = student.getSubjects();
		for(Subject s: studentsSubjects) {
			subjects.add(s);
		}
		
		student.setSubjects(subjects);
		studentsServices.saveOrUpdateStudent(student);
		// Sending data to student details
		model.addAttribute("subjects", subjects);
		Set<Exam> exams = student.getExams();
		model.addAttribute("exams", exams);
		model.addAttribute("student", student);
		return "student_details";

	}

	@RequestMapping(value = "/dodeletestudent/{id}")
	public String deleteStudent(@PathVariable int id, Model model) {
		studentsServices.deleteStudent(id);
		List<Student> students = studentsServices.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}

	 @RequestMapping("/students/{page}/{num}")
	    public String paginatedStudents(@PathVariable("page") int page, @PathVariable("num") int num, Model model) {
	        model.addAttribute("pages", Math.ceil((double)studentsServices.getAllStudents().size()/num));
	        model.addAttribute("num", num);
	        model.addAttribute("students", studentsServices.getPaginated(page, num));
	        return "students";
	    }
}
