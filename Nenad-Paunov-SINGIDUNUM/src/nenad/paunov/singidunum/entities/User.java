package nenad.paunov.singidunum.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@NotNull
	@Column(unique = true)
	private String username;
	@NotNull
	private String password;
	@NotNull
	@Column(unique = true)
	private String email;
	private boolean enabled = true;
	@OneToOne(cascade = CascadeType.ALL,mappedBy="user")
	//@PrimaryKeyJoinColumn 
	private Authority user_authority;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	

	public Authority getUser_authority() {
		return user_authority;
	}

	public void setUser_authority(Authority user_authority) {
		this.user_authority = user_authority;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled
				+ ", authority=" + user_authority + "]";
	}
	

}
