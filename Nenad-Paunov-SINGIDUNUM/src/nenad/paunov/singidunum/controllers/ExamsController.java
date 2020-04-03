package nenad.paunov.singidunum.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nenad.paunov.singidunum.entities.Exam;
import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.entities.Subject;

import nenad.paunov.singidunum.services.ExamsService;
import nenad.paunov.singidunum.services.ProfessorsService;
import nenad.paunov.singidunum.services.SubjectsService;

@Controller
public class ExamsController {
	@Autowired
	private ProfessorsService professorsServices;
	@Autowired
	private SubjectsService subjectService;
	@Autowired
	private ExamsService examsService;

	@RequestMapping("/exams")
	public String showExams(Model model) {
		List<Exam> exams = examsService.getAllExams();
		model.addAttribute("exams", exams);
		return "exams";
	}

	@RequestMapping("/createexam")
	public String createExam(Model model) {
		List<Subject> subjects = subjectService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		List<Professor> professors = professorsServices.getAllProfessors();
		model.addAttribute("professors", professors);

		return "createexam";
	}

	@RequestMapping(value = "/docreateexam", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Exam exam, Professor professor, Subject subject, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "createexam";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}
		Professor newProfessor = professorsServices.getProfessor(professor.getId());
		exam.setProfessor(newProfessor);

		Subject newSubject = subjectService.getSubject(subject.getSubjectId());
		exam.setSubject(newSubject);

		examsService.saveOrUpdateExam(exam);
		model.addAttribute("exam", exam);
		return "examcreated";
	}
}
