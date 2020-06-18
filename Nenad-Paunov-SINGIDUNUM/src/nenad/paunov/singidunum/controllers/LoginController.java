package nenad.paunov.singidunum.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nenad.paunov.singidunum.entities.Authority;
import nenad.paunov.singidunum.entities.User;
import nenad.paunov.singidunum.services.AuthorityService;
import nenad.paunov.singidunum.services.UsersService;

@Controller
public class LoginController {

	@Autowired
	UsersService usersService;
	@Autowired
	AuthorityService authorityService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/loggedout")
	public String showLoggedOut() {
		return "loggedout";
	}

	@RequestMapping("/create_account")
	public String showNewAccount(Model model) {
		return "create_account";
	}
	
	@RequestMapping("/users")
	public String showAllUsers(Model model) {
		List<User> users = usersService.getAllUsers();
		model.addAttribute("users",users);
		return "users";
	}
	
	@RequestMapping(value = "/docreateaccount", method = RequestMethod.POST)
	public String doCreate(Model model, User user, @RequestParam String author, BindingResult result) {
		System.out.println("Poslao sam podatke");
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "create_account";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}
		System.out.println(user);
		Authority authority = new Authority();
		authority.setAuthUsername(user.getUsername());
		authority.setAuthority(author);
		//authorityService.saveOrUpdateAuthority(authority);
		user.setUser_authority(authority);
		String springPassword = "{noop}" + user.getPassword();
		user.setPassword(springPassword);
		usersService.saveOrUpdateUser(user);
		model.addAttribute("user", user);
		model.addAttribute("authority", authority);
		return "user_created";
	}
	
	

}
