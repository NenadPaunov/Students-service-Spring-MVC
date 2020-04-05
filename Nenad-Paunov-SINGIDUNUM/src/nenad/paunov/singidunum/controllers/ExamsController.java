package nenad.paunov.singidunum.controllers;

import java.util.List;
import java.util.Set;

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

	@RequestMapping("/create_exam")
	public String createExam(Model model) {
		List<Subject> subjects = subjectService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "create_exam";
	}

	@RequestMapping(value = "/create_exam2", method = RequestMethod.POST)
	public String createExam2(Model model, Exam exam, Subject subject) {
		Subject subjectName = subjectService.getSubject(subject.getSubjectId());
		if (examsService.getExamsByDate(exam.getExamDate(), subjectName.getName()).size() > 0) {
			String message = "Exam for this subject is still active";
			model.addAttribute("message", message);
			List<Subject> subjects = subjectService.getAllSubjects();
			model.addAttribute("subjects", subjects);
			return "create_exam";
		}
		Set<Professor> professors = subjectService.getProfessorsBySubject(subject.getSubjectId());
		model.addAttribute("professors", professors);
		Subject subjectDatabase = subjectService.getSubject(subject.getSubjectId());
		model.addAttribute("subjectDatabase", subjectDatabase);
		model.addAttribute("exam", exam);
		return "create_exam2";
	}

	@RequestMapping(value = "/docreateexam", method = RequestMethod.POST)
	public String doCreateTest(Model model, Exam exam, Professor professor, Subject subject) {

		Professor newProfessor = professorsServices.getProfessor(professor.getId());
		exam.setProfessor(newProfessor);

		Subject subjectDatabase = subjectService.getSubject(subject.getSubjectId());
		exam.setSubject(subjectDatabase);

		exam.setExamName(subjectDatabase.getName());
		examsService.saveOrUpdateExam(exam);
		model.addAttribute("exam", exam);
		return "examcreated";
	}
}
