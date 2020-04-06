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

import nenad.paunov.singidunum.entities.Exam;
import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.entities.Subject;

import nenad.paunov.singidunum.services.ExamsService;
import nenad.paunov.singidunum.services.ProfessorsService;
import nenad.paunov.singidunum.services.StudentsService;
import nenad.paunov.singidunum.services.SubjectsService;

@Controller
public class ExamsController {
	@Autowired
	private ProfessorsService professorsServices;
	@Autowired
	private SubjectsService subjectService;
	@Autowired
	private ExamsService examsService;
	@Autowired
	private StudentsService studentsService;

	@RequestMapping("/exams")
	public String showExams(Model model) {
		List<Exam> exams = examsService.getAllExams();
		model.addAttribute("exams", exams);
		return "exams";
	}

	@RequestMapping("/exam_details/{examId}")
	public String showExamDetails(@PathVariable int examId, Model model) {
		Exam exam = examsService.getExam(examId);
		model.addAttribute("exam", exam);
		Professor professor = exam.getProfessor();
		model.addAttribute("professor", professor);
		Set<Student> students = exam.getStudents();
		model.addAttribute("students", students);
		Subject subject = exam.getSubject();
		model.addAttribute("subject", subject);
		return "exam_details";
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
		return "exam_created";
	}

	@RequestMapping(value = "/doupdateexam/{examId}")
	public String updateExam(@PathVariable int examId, Model model) {
		Exam exam = examsService.getExam(examId);
		Set<Professor> professors = subjectService.getProfessorsBySubjectName(exam.getExamName());
		model.addAttribute("professors", professors);
		model.addAttribute("exam", exam);

		Subject subject = subjectService.getSubjectByName(exam.getExamName());
		model.addAttribute("subject", subject);
		return "update_exam";
	}

	@RequestMapping(value = "/updateexam/{examId}", method = RequestMethod.POST)
	public String doUpdate(@PathVariable int examId, Model model, @Valid Exam exam, Professor professor,
			Subject subject, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "update_exam";
			}
		} else if (examsService.getExamsByDate(exam.getExamDate(), exam.getExamName()).size() > 0) {
			String message = "Exam for this subject is still active";
			model.addAttribute("message", message);
			Set<Professor> professors = subjectService.getProfessorsBySubjectName(exam.getExamName());
			model.addAttribute("professors", professors);
			return "update_exam";
		}

		else {
			System.out.println("Form validated successsfully!");
		}
		Professor newProfessor = professorsServices.getProfessor(professor.getId());
		exam.setProfessor(newProfessor);

		Subject subjectDatabase = subjectService.getSubjectByName(exam.getExamName());
		exam.setSubject(subjectDatabase);

		examsService.saveOrUpdateExam(exam);
		System.out.println(exam);
		model.addAttribute("exam", exam);
		return "exam_created";
	}

	@RequestMapping(value = "/dodeleteexam/{examId}")
	public String deleteStudent(@PathVariable int examId, Model model) {
		examsService.deleteExam(examId);
		List<Exam> exams = examsService.getAllExams();
		model.addAttribute("exams", exams);
		return "exams";
	}

	// Exam registration
	@RequestMapping("/exam_registration")
	public String createExamRegistration(Model model) {
		List<Subject> subjects = subjectService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		List<Student> students = studentsService.getAllStudents();
		model.addAttribute("students", students);
		return "exam_registration";
	}

	@RequestMapping(value = "/exam_registration2", method = RequestMethod.POST)
	public String createExamRegistration(Model model, Subject subject, Student student) {
		Subject subjectDatabase = subjectService.getSubject(subject.getSubjectId());
		Exam exam = examsService.getExamByName(subjectDatabase.getName());
		if (!examsService.getRegisterExamDate(exam.getExamName())) {
			String message = "The exam can only be registered in the last week before the exam begins";
			model.addAttribute("message", message);
			List<Subject> subjects = subjectService.getAllSubjects();
			model.addAttribute("subjects", subjects);
			List<Student> students = studentsService.getAllStudents();
			model.addAttribute("students", students);
			return "exam_registration";
		}
		Student studentDatabase = studentsService.getStudent(student.getId());
		if (studentDatabase.getCurrentYearOfStudy() <= subjectDatabase.getYearOfStudy()) {
			String message = "Student can only apply for exams from the current or from the previous years ";
			model.addAttribute("message", message);
			List<Subject> subjects = subjectService.getAllSubjects();
			model.addAttribute("subjects", subjects);
			List<Student> students = studentsService.getAllStudents();
			model.addAttribute("students", students);
			return "exam_registration";
		}
		Set<Student> students = new HashSet<Student>();
		students.add(studentDatabase);
		exam.setStudents(students);
		examsService.saveOrUpdateExam(exam);
		String message = "You have successfully registrated exam from " + exam.getExamName() + " for student: "
				+ studentDatabase.getFirstName() + " " + studentDatabase.getLastName();
		model.addAttribute("message", message);
		model.addAttribute("exam", exam);
		return "exam_registration2";

	}

}
