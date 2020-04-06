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
		return userDao.listUsers();
	}

	public User createNewUser(User c) {
		return userDao.addUser(c);
	}

	public void updateUser(User c) {
		userDao.update(c);
		System.out.println("Updated User!");
	}

	public User getOneUser(int id) {
		return userDao.getUserById(id);
	}

	public void deleteUser(int id) {
		userDao.removeUser(id);
		System.out.println("Deleted User!");
	}
}
