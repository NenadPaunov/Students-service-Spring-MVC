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

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Authority addAuthority(Authority c) {
		Session s = this.sessionFactory.getCurrentSession();
		s.save(c);
		return c;
	}

	public void update(Authority c) {
		Session s = this.sessionFactory.getCurrentSession();
		s.update(c);
	}

	public List<Authority> listAuthorities() {
		Session s = this.sessionFactory.getCurrentSession();
		List<Authority> list = s.createQuery("From Authority").list();
		return list;
	}

	public Authority getAuthorityById(int id) {
		Session s = this.sessionFactory.getCurrentSession();
		Authority c = s.load(Authority.class, new Integer(id));
		return c;
	}

	public void removeAuthority(int id) {
		Session s = this.sessionFactory.getCurrentSession();
		Authority c = s.load(Authority.class, new Integer(id));
		if (c != null) {
			s.remove(c);
		}
	}
}