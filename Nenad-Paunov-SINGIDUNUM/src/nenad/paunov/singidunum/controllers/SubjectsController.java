package nenad.paunov.singidunum.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import nenad.paunov.singidunum.entities.City;
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

	@RequestMapping("/subject_details/{subjectId}")
	public String showSubjectDetails(@PathVariable int subjectId, Model model) {
		Subject subject = subjectsService.getSubject(subjectId);
		model.addAttribute("subject", subject);
		Set<Professor> professors = subject.getProfessor();
		model.addAttribute("professors", professors);
		return "subject_details";
	}
	
	@RequestMapping("/create_subject")
	public String createSubject(Model model) {
		List<Professor> professors = professorsServices.getAllProfessors();
		model.addAttribute("professors", professors);
		return "create_subject";
	}

	@RequestMapping(value = "/docreatesubject", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Subject subject, @RequestParam ArrayList<Integer> list,
			Professor professor, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "create_subject";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}
		Set<Professor> profs = new HashSet<Professor>();
		for (Integer profId : list) {
			Professor newProfessor = professorsServices.getProfessor(profId);
			profs.add(newProfessor);
		}
		subject.setProfessor(profs);
		subjectsService.saveOrUpdateSubject(subject);
		model.addAttribute("subject", subject);
		return "subject_created";
	}

	@RequestMapping(value = "/doupdatesubject/{subjectId}")
	public String updateSubject(@PathVariable int subjectId, Model model) {
		Subject subject = subjectsService.getSubject(subjectId);
		List<Professor> professors = professorsServices.getAllProfessors();
		model.addAttribute("professors", professors);
		model.addAttribute("subject", subject);
		model.addAttribute("subjectId", subjectId);
		return "update_subject";
	}

	@RequestMapping(value = "/updatesubject/{subjectId}", method = RequestMethod.POST)
	public String doUpdate(@PathVariable int subjectId, @RequestParam ArrayList<Integer> list, Model model,
			@Valid Subject subject, Professor professor, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "update_subject";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}
		Set<Professor> profs = new HashSet<Professor>();
		for (Integer profId : list) {
			Professor newProfessor = professorsServices.getProfessor(profId);
			profs.add(newProfessor);
		}
		subject.setProfessor(profs);
		subjectsService.saveOrUpdateSubject(subject);
		model.addAttribute("subject", subject);
		return "subject_created";
	}

	@RequestMapping(value = "/dodeletesubject/{id}")
	public String deleteSubject(@PathVariable int id, Model model) {
		subjectsService.deleteSubject(id);
		List<Subject> subjects = subjectsService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "subjects";
	}
	
	 @RequestMapping("/subjects/{page}/{num}")
	    public String paginatedSubjects(@PathVariable("page") int page, @PathVariable("num") int num, Model model) {
	        model.addAttribute("pages", Math.ceil((double)subjectsService.getAllSubjects().size()/num));
	        model.addAttribute("num", num);
	        model.addAttribute("subjects", subjectsService.getPaginated(page, num));
	        return "subjects";
	    }
}
