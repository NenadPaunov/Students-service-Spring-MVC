package nenad.paunov.singidunum.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student extends Person {
	@NotNull(message = "Index number cannot be null")
	@Size(min = 10, max = 10, message = "Index number must have 10 characters")
	@Column(unique = true, name = "IndexNumber")
	private String indexNumber;
	@NotNull(message = "Current year of study cannot be null")
	@Size(max = 7, message = "Current year of study can not have more then 7 characters")
	@Column(name = "CurrentYearOfStudy")
	private int currentYearOfStudy;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "StudentsSubjects", joinColumns = @JoinColumn(name = "Id"), inverseJoinColumns = @JoinColumn(name = "SubjectId"))
	private Set<Subject> subjects = new HashSet<Subject>();
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "StudentsExams", joinColumns = @JoinColumn(name = "Id"), inverseJoinColumns = @JoinColumn(name = "ExamId"))
	private Set<Exam> exams = new HashSet<Exam>();
}
