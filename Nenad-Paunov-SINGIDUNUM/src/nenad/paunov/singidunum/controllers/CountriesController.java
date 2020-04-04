package nenad.paunov.singidunum.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nenad.paunov.singidunum.entities.Country;
import nenad.paunov.singidunum.entities.Professor;
import nenad.paunov.singidunum.services.CountriesService;

@Controller
public class CountriesController {
	@Autowired
	private CountriesService countriesService;
	
	@RequestMapping("/countries")
	public String showCountries(Model model) {
		List<Country> countries = countriesService.getAllCountries();
		model.addAttribute("countries",countries);
		return "countries";		
	}
	
	@RequestMapping("/create_country")
	public String createCountry(Model model){	
		return "create_country";
	}
	@RequestMapping(value="/docreatecountry", method=RequestMethod.POST)
	public String doCreate(Model model,@Valid Country country, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError e: errors) {
				System.out.println(e.getDefaultMessage());
			return "create_country";
			}
		}else {
			System.out.println("Form validated successsfully!");			
		}
		
		countriesService.saveOrUpdateCountry(country);
		model.addAttribute("country",country);
		return "country_created";
	}
	
	@RequestMapping(value ="/dodeletecountry/{id}")
	public String deleteCountry(@PathVariable int id, Model model) {
		countriesService.deleteCountry(id);
		List<Country> countries = countriesService.getAllCountries();
		model.addAttribute("countries", countries);
		return "countries";
	}
}
