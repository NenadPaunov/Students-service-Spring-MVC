package nenad.paunov.singidunum.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
@Entity
@Table(name="Exams")
public class Exam {
	@Id
	@GeneratedValue
	@Column(name = "ExamId")
	private int examId;
	@NotNull
	@Column(name="ExamName")
	private String examName;
	@NotNull
	@Range(min = 1, max = 12, message = "Please select only numbers from 1 to 12")
	@Column(name="ESPB")
	private int espb;
	@NotNull
	@Column(name = "examDate")
	private Date examDate;
	@ManyToOne
	private Subject subject;
	@ManyToOne
	private Professor professor;
	@ManyToMany(fetch = FetchType.LAZY,
	        cascade =
	        {
	                CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST
	        },
	        targetEntity = Student.class)
	@JoinTable(name = "StudentsExams",
	        inverseJoinColumns = @JoinColumn(name = "studentId",
	                nullable = false,
	                updatable = false),
	        joinColumns = @JoinColumn(name = "examId",
	                nullable = false,
	                updatable = false),
	        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
	        inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
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
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getEspb() {
		return espb;
	}
	public void setEspb(int espb) {
		this.espb = espb;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "examName=" + examName + ", espb=" + espb + ", examDate=" + examDate;
	}
	
	
	
	
}
