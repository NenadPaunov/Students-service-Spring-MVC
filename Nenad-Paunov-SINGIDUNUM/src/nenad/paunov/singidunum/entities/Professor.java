package nenad.paunov.singidunum.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="Professors")
public class Professor extends Person {
	@NotNull
	@Column(name = "ReelectionDate")
	private Date reelectionDate;
	@ManyToOne
	@JoinColumn(name = "TitleId")
	private Title titles;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ProfessorsSubjects", joinColumns = @JoinColumn(name = "Id"), inverseJoinColumns = @JoinColumn(name = "SubjectId"))
	private Set<Subject> subjects = new HashSet<Subject>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id")
	private List<Exam> exams = new ArrayList<Exam>();
	
	public Date getReelectionDate() {
		return reelectionDate;
	}
	
	public void setReelectionDate(Date reelectionDate) {
		this.reelectionDate = reelectionDate;
	}
	public Title getTitles() {
		return titles;
	}
	public void setTitles(Title titles) {
		this.titles = titles;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public Professor() {
		
	}
	@Override
	public String toString() {
		return super.toString()+ "Professor [reelectionDate=" + reelectionDate + ", titles=" + titles + ", subjects=" + subjects
				+ ", exams=" + exams + "]";
	}
	
	
}
