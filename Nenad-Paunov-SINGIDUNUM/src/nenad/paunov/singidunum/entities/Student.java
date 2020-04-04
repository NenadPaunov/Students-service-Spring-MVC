package nenad.paunov.singidunum.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
@Entity
@Table(name="Students")
public class Student extends Person {
	@NotNull(message = "Index number cannot be null")
	@Size(min = 1, max = 10, message = "Index number must have 10 characters")
	@Column(unique = true, name = "IndexNumber")
	private String indexNumber;
	@NotNull(message = "Current year of study cannot be null")
	@Range(min = 1, max = 7, message = "Please select only numbers from 1 to 7")
	@Column(name = "CurrentYearOfStudy")
	private int currentYearOfStudy;
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "StudentsSubjects", joinColumns = @JoinColumn(name = "Id"), inverseJoinColumns = @JoinColumn(name = "SubjectId"))
	private Set<Subject> subjects = new HashSet<Subject>();
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "StudentsExams", joinColumns = @JoinColumn(name = "Id"), inverseJoinColumns = @JoinColumn(name = "ExamId"))
	private Set<Exam> exams = new HashSet<Exam>();
	public String getIndexNumber() {
		return indexNumber;
	}
	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}
	public int getCurrentYearOfStudy() {
		return currentYearOfStudy;
	}
	public void setCurrentYearOfStudy(int currentYearOfStudy) {
		this.currentYearOfStudy = currentYearOfStudy;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public Set<Exam> getExams() {
		return exams;
	}
	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
	@Override
	public void setCity(City city) {
		super.setCity(city);
	}

	@Override
	public String toString() {
		return super.toString()+" Student [indexNumber=" + indexNumber + ", currentYearOfStudy=" + currentYearOfStudy + ", subjects="
				+ subjects + ", exams=" + exams + "]";
	}
	
	
	
}
