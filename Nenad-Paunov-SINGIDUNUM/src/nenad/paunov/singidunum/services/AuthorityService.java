package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.AuthorityDAO;
import nenad.paunov.singidunum.entities.Authority;

@Service
public class AuthorityService {

	@Autowired
	private AuthorityDAO AuthorityDao;

	public List<Authority> getAllAuthorities() {
		return AuthorityDao.listAuthorities();
	}

	public Authority createNewAuthority(Authority c) {
		return AuthorityDao.addAuthority(c);
	}

	public void updateAuthority(Authority c) {
		AuthorityDao.update(c);
		System.out.println("Updated Authority!");
	}

	public Authority getOneAuthority(int id) {
		return AuthorityDao.getAuthorityById(id);
	}

	public void deleteAuthority(int id) {
		AuthorityDao.removeAuthority(id);
		System.out.println("Deleted Authority!");
	}
}