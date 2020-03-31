package nenad.paunov.singidunum.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Contries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	private int countryId;
	@NotNull(message = "Country name cannot be null")
	@Size(min = 2, max = 30, message = "Country name must be between 2 and 30 characters")
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private City city;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country() {

	}


	public Country(int countryId,
			@NotNull(message = "Country name cannot be null") @Size(min = 2, max = 30, message = "Country name must be between 2 and 30 characters") String name) {
		super();
		this.countryId = countryId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", name=" + name + "]";
	}

}