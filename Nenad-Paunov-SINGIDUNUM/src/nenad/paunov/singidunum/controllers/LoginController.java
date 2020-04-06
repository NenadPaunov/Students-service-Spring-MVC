package nenad.paunov.singidunum.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nenad.paunov.singidunum.dao.UserDAO;
import nenad.paunov.singidunum.entities.User;

@Controller
public class LoginController {

	@Autowired
	UserDAO usersDao;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/loggedout")
	public String showLoggedOut() {
		return "loggedout";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		// user
		model.addAttribute("user", new User());
		return "newaccount";
	}

}
