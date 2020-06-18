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
		return AuthorityDao.getAllAuthorities();
	}

	public Authority saveOrUpdateAuthority(Authority authority) {
		return AuthorityDao.saveOrUpdateAuthority(authority);
	}

	public Authority getAuthorityById(int id) {
		return AuthorityDao.getAuthorityById(id);
	}

	public void deleteAuthority(int id) {
		AuthorityDao.removeAuthority(id);
	}
}