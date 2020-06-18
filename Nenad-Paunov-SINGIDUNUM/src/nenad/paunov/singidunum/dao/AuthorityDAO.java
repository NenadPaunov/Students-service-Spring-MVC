package nenad.paunov.singidunum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nenad.paunov.singidunum.entities.Authority;

@Component
@Transactional
public class AuthorityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Authority saveOrUpdateAuthority(Authority authority) {
		sessionFactory.getCurrentSession().saveOrUpdate(authority);
		;
		return authority;
	}

	@SuppressWarnings("unchecked")
	public List<Authority> getAllAuthorities() {
		return sessionFactory.getCurrentSession().createQuery("FROM Authority").list();

	}

	public Authority getAuthorityById(int id) {
		return sessionFactory.getCurrentSession().get(Authority.class, id);
	}

	public void removeAuthority(int id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Authority.class, id));

	}
}