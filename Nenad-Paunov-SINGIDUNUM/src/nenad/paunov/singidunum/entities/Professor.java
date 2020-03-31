package nenad.paunov.singidunum.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

public class Professor extends Person {
	@NotNull
	@Column(name = "ReelectionDate")
	private Date reelectionDate;
	@ManyToOne
	@JoinColumn(name = "Id")
	private Title title;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ProfessorsSubjects", joinColumns = @JoinColumn(name = "Id"), inverseJoinColumns = @JoinColumn(name = "SubjectId"))
	private Set<Subject> subjects = new HashSet<Subject>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id")
	private List<Exam> exams = new ArrayList<Exam>();
}
