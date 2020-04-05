package nenad.paunov.singidunum.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@NotNull(message = "ReelectionDate cannot be null")
	@Column(name = "ReelectionDate")
	private Date reelectionDate;
	@ManyToOne
	private Title title;
	@ManyToMany(mappedBy="professor", cascade = CascadeType.DETACH)
	private Set<Subject> subjects = new HashSet<Subject>();
	@OneToMany(mappedBy="professor")
	private List<Exam> exams = new ArrayList<Exam>();
	
	public Date getReelectionDate() {
		return reelectionDate;
	}
	
	public void setReelectionDate(Date reelectionDate) {
		this.reelectionDate = reelectionDate;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
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
		return super.toString()+ "Professor [reelectionDate=" + reelectionDate + ", title=" + title;
	}
	
	
}
