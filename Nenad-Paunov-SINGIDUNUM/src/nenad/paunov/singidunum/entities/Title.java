package nenad.paunov.singidunum.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Titles")
public class Title {
	@Id
	@GeneratedValue
	@Column(name = "TitleId")
	private int titleId;
	@NotNull(message = "Title name cannot be null")
	@Size(min = 2, max = 30, message = "Title name must be between 2 and 30 characters")
	@Column(name = "TitleName")
	private String titleName;
	@OneToMany(mappedBy="title")
	private List<Professor> professors = new ArrayList<Professor>();
	
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public List<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	@Override
	public String toString() {
		return "Title: " + titleName;
	}
	
	
	
}
