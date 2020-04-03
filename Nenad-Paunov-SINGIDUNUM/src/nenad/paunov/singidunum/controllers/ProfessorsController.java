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

import nenad.paunov.singidunum.entities.City;
import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.entities.Title;
import nenad.paunov.singidunum.services.CitiesService;
import nenad.paunov.singidunum.services.ProfessorsService;
import nenad.paunov.singidunum.services.StudentsService;
import nenad.paunov.singidunum.services.TitlesService;

@Controller
public class ProfessorsController {
	@Autowired
	private ProfessorsService professorsServices;
	@Autowired
	private CitiesService citiesService;
	@Autowired
	private TitlesService titlesService;

	@RequestMapping("/professors")
	public String showProfessors(Model model) {
		List<Professor> professors = professorsServices.getAllProfessors();
		model.addAttribute("professors",professors);
		return "professors";		
	}
	
	@RequestMapping("/createprofessor")
	public String createProfessor(Model model){	
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities",cities);
		List<Title> titles = titlesService.getAllTitles();
		model.addAttribute("titles",titles);
		return "createprofessor";
	}
	@RequestMapping(value="/docreateprofessor", method=RequestMethod.POST)
	public String doCreate(Model model,@Valid Professor professor,City city, Title title, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError e: errors) {
				System.out.println(e.getDefaultMessage());
			return "createprofessor";
			}
		}else {
			System.out.println("Form validated successsfully!");			
		}
		
		City newCity = citiesService.getCity(city.getCityId());
		professor.setCity(newCity);
		
		Title newTitle = titlesService.getTitle(title.getTitleId());
		professor.setTitles(newTitle);
		
		professorsServices.saveOrUpdateProfessor(professor);
		model.addAttribute("professor",professor);
		return "professorcreated";
	}
}
