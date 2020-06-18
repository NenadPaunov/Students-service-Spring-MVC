package nenad.paunov.singidunum.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {

	@Id
	@Column(name="username")
	private String authUsername;
	private String authority;
	@OneToOne
	//@JoinColumn(name="username")
	//@MapsId
	private User user;

	public Authority() {
		// TODO Auto-generated constructor stub
	}


	public String getAuthUsername() {
		return authUsername;
	}

	public void setAuthUsername(String authUsername) {
		this.authUsername = authUsername;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}


	@Override
	public String toString() {
		return "Authority [authUsername=" + authUsername + ", authority=" + authority + "]";
	}

	

}