package nenad.paunov.singidunum.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min = 1, max = 1, message = "Year of study must have only one number")
	private int yearOfStudy;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Semester semester;
	@ManyToMany
	@JoinColumn(name = "Id")
	private Set<Student> students;
	@ManyToMany
	@JoinColumn(name = "Id")
	private Set<Professor> professor;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SubjectId")
	private Exam exam;

	public enum Semester {
		SUMMER, WINTER
	}
}
