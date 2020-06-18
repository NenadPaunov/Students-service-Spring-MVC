package nenad.paunov.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nenad.paunov.singidunum.dao.UserDAO;
import nenad.paunov.singidunum.entities.User;

@Service
public class UsersService {

	@Autowired
	private UserDAO userDao;

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User saveOrUpdateUser(User user) {
		return userDao.saveOrUpdateUser(user);
	}

	public User getUser(int id) {
		return userDao.getUserById(id);
	}

	public void deleteUser(int id) {
		userDao.removeUser(id);
	}
}
