package nenad.paunov.singidunum.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="Exams")
public class Exam {
	@Id
	@GeneratedValue
	@Column(name = "ExamId")
	private int examId;
	@NotNull(message = "Exam`s date cannot be null")
	@Column(name = "Name")
	private Date examDate;
	@ManyToOne
	@JoinColumn(name = "SubjectId")
	private Subject subject;
	@ManyToOne
	@JoinColumn(name = "Id")
	private Professor professor;
	@ManyToMany
	@JoinColumn(name = "Id")
	private Set<Student> students = new HashSet<Student>();
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examDate=" + examDate + ", subject=" + subject + ", professor=" + professor
				+ "]";
	}
	
	
}
