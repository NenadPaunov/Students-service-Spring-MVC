package nenad.paunov.singidunum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nenad.paunov.singidunum.entities.User;

@Component
@Transactional
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User addUser(User c) {
		Session s = this.sessionFactory.getCurrentSession();
		s.save(c);
		return c;
	}

	public void update(User c) {
		Session s = this.sessionFactory.getCurrentSession();
		s.update(c);
	}

	public List<User> listUsers() {
		Session s = this.sessionFactory.getCurrentSession();
		List<User> list = s.createQuery("From User").list();
		return list;
	}

	public User getUserById(int id) {
		Session s = this.sessionFactory.getCurrentSession();
		User c = s.load(User.class, new Integer(id));
		return c;
	}

	public void removeUser(int id) {
		Session s = this.sessionFactory.getCurrentSession();
		User c = s.load(User.class, new Integer(id));
		if (c != null) {
			s.remove(c);
		}
	}
}
