package nenad.paunov.singidunum.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cities")
public class City {
	@Id
	@Size(max=7)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CityId")
	private int cityId;
	@NotNull(message = "City name cannot be null")
	@Size(min = 2, max = 30, message = "City name must be between 2 and 30 characters")
	@Column(name="Name")
	private String name;
	@Size(min = 2, max = 10, message = "Zip code lenght must be between 2 and 10 characters")
	@Column(name = "ZipCode")
	private String zipCode;
	@ManyToOne
	@JoinColumn(name = "CountryId")
	private List<Country> countries = new ArrayList<Country>();
	@OneToMany
	@JoinColumn(name = "Id")
	private Person person;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + ", zipCode=" + zipCode + "]";
	}

}
