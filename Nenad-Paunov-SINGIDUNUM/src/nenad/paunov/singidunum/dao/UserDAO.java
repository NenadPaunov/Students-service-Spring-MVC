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

	public User saveOrUpdateUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("FROM User").list();
	}

	public User getUserById(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void removeUser(int id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
	}
}
