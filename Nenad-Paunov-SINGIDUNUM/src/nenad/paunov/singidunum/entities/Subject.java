package nenad.paunov.singidunum.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="Subjects")
public class Subject {
	@Id
	@GeneratedValue
	@Column(name = "SubjectId")
	private int subjectId;
	@NotNull(message = "Subject name cannot be null")
	@Size(min = 2, max = 30, message = "Subject name must be between 3 and 30 characters")
	@Column(name="Name")
	private String name;
	@Size(max = 200, message = "Description can not exceed 200 characters")
	@Column(name="Description")
	private String description;
	@Column(name = "YearOfStudy")
	@Max(1)
	private int yearOfStudy;
	@Size(max=10)
	private String semester;
	@ManyToMany
	@JoinColumn(name = "Id")
	private Set<Student> students;
	@ManyToMany
	@JoinColumn(name = "Id")
	private Set<Professor> professor;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SubjectId")
	private List<Exam> exams = new ArrayList<Exam>();
	


	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(Set<Professor> professor) {
		this.professor = professor;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", name=" + name + ", description=" + description + ", yearOfStudy="
				+ yearOfStudy + ", semester=" + semester + ", students=" + students + ", professor=" + professor + "]";
	}
	
	
}
