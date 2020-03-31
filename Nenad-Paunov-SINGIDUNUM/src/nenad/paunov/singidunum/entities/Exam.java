package nenad.paunov.singidunum.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Exam {
	@Id
	@GeneratedValue
	@Column(name = "ExamId")
	private int examId;
	@NotNull(message = "Exam name cannot be null")
	@Size(min = 2, max = 30, message = "Exam name must be between 3 and 30 characters")
	@Column(name = "Name")
	private String name;
	@NotNull(message = "Exam`s date cannot be null")
	@Column(name = "Name")
	private Date examDate;
	@ManyToOne
	@JoinColumn(name = "SubjectId")
	private List<Subject> subjects = new ArrayList<Subject>();
	@ManyToOne
	@JoinColumn(name = "Id")
	private Professor professor;
}
