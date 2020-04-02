package nenad.paunov.singidunum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import nenad.paunov.singidunum.entities.City;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.services.CitiesService;

@Controller
public class CitiesController {
	@Autowired
	private CitiesService citiesService;
	
	@RequestMapping("/cities")
	public String showStudents(Model model) {
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities",cities);
		return "cities";		
	}
}
