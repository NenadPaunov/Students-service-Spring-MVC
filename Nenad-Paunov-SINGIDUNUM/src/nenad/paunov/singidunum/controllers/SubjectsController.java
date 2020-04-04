package nenad.paunov.singidunum.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.entities.Subject;
import nenad.paunov.singidunum.services.ProfessorsService;
import nenad.paunov.singidunum.services.SubjectsService;

@Controller
public class SubjectsController {
	@Autowired
	private ProfessorsService professorsServices;
	@Autowired
	private SubjectsService subjectsService;

	@RequestMapping("/subjects")
	public String showSubjects(Model model) {
		List<Subject> subjects = subjectsService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "subjects";
	}

	@RequestMapping("/createsubject")
	public String createSubject(Model model) {
		List<Professor> professors = professorsServices.getAllProfessors();
		model.addAttribute("professors", professors);
		return "createsubject";
	}

	@RequestMapping(value = "/docreatesubject", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Subject subject, Professor professor, BindingResult result) {
		System.out.println("Usao");
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "createsubject";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}
		Set<Professor> profs = new HashSet<Professor>();
		Professor newProfessor = professorsServices.getProfessor(professor.getId());
		profs.add(newProfessor);
		subject.setProfessor(profs);
		subjectsService.saveOrUpdateSubject(subject);
		model.addAttribute("subject", subject);
		return "subject_created";
	}
	
	@RequestMapping(value ="/dodeletesubject/{id}")
	public String deleteSubject(@PathVariable int id, Model model) {
		subjectsService.deleteSubject(id);
		List<Subject> subjects = subjectsService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "subjects";
	}
}
