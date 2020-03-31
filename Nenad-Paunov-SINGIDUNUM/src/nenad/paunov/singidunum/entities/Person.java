package nenad.paunov.singidunum.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	@NotNull(message = "First name cannot be null")
	@Column(name = "FirstName")
	@Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters")
	private String firstName;
	@NotNull(message = "Last name cannot be null")
	@Column(name = "LastName")
	@Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters")
	private String lastName;
	@Column(unique = true,name= "Email")
	@Size(max=30)
	@Email(message = "Invalid email format")
	private String email;
	@Size(min = 3, max = 30, message = "Address must be between 3 and 50 characters")
	@Column(name="Address")
	private String address;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Id")
	private List<City> cities;
	@Size(min = 3, max = 30, message = "Phone number must be between 6 and 15 characters")
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
