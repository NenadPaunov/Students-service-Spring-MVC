package nenad.paunov.singidunum.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.ConstraintMode;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
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
	@NotNull(message = "Description cannot be null")
	@Size(max = 200, message = "Description can not exceed 200 characters")
	@Column(name="Description")
	private String description;
	@NotNull(message = "YearOfStudy cannot be null")
	@Column(name = "YearOfStudy")
	@Range(min = 1, max = 4, message = "Please select only numbers from 1 to 4")
	private int yearOfStudy;
	@Size(max=10)
	private String semester;
	@ManyToMany(fetch = FetchType.LAZY,
	        cascade =
	        {
	                CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST
	        },
	        targetEntity = Student.class)
	@JoinTable(name = "StudentsSubjects",
	        inverseJoinColumns = @JoinColumn(name = "studentId",
	                nullable = false,
	                updatable = false),
	        joinColumns = @JoinColumn(name = "subjectId",
	                nullable = false,
	                updatable = false),
	        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
	        inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Set<Student> students;
	@ManyToMany(fetch = FetchType.LAZY,
	        cascade =
	        {
	                CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST
	        },
	        targetEntity = Professor.class)
	@JoinTable(name = "ProfessorsSubjects",
	        inverseJoinColumns = @JoinColumn(name = "professorId",
	                nullable = false,
	                updatable = false),
	        joinColumns = @JoinColumn(name = "subjectId",
	                nullable = false,
	                updatable = false),
	        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
	        inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Set<Professor> professor;
	@OneToMany(mappedBy="subject")
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
