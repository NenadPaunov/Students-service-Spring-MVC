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

import nenad.paunov.singidunum.entities.City;
import nenad.paunov.singidunum.entities.Country;
import nenad.paunov.singidunum.entities.Student;
import nenad.paunov.singidunum.entities.Title;
import nenad.paunov.singidunum.services.CitiesService;
import nenad.paunov.singidunum.services.CountriesService;

@Controller
public class CitiesController {
	@Autowired
	private CitiesService citiesService;
	@Autowired
	private CountriesService countriesService;

	@RequestMapping("/cities")
	public String showCities(Model model) {
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities", cities);
		return "cities";
	}

	@RequestMapping("/create_city")
	public String createCity(Model model) {
		List<Country> countries = countriesService.getAllCountries();
		model.addAttribute("countries", countries);
		return "create_city";
	}

	@RequestMapping(value = "/docreatecity", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid City city, Country country, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "create_city";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}

		Country newCountry = countriesService.getCountry(country.getCountryId());
		city.setCountry(newCountry);
		citiesService.saveOrUpdateCity(city);
		model.addAttribute("city", city);
		return "city_created";
	}

	@RequestMapping(value = "/doupdatecity/{cityId}")
	public String updateCity(@PathVariable int cityId, Model model) {
		List<Country> countries = countriesService.getAllCountries();
		model.addAttribute("countries", countries);
		City city = citiesService.getCity(cityId);
		model.addAttribute("city", city);
		model.addAttribute("cityId", cityId);
		return "update_city";
	}

	@RequestMapping(value = "/updatecity/{cityId}", method = RequestMethod.POST)
	public String doUpdate(@PathVariable int cityId, Model model, @Valid City city, Country country,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e : errors) {
				System.out.println(e.getDefaultMessage());
				return "create_city";
			}
		} else {
			System.out.println("Form validated successsfully!");
		}

		Country newCountry = countriesService.getCountry(country.getCountryId());
		city.setCountry(newCountry);
		citiesService.saveOrUpdateCity(city);
		model.addAttribute("city", city);
		return "city_created";
	}

	@RequestMapping(value = "/dodeletecity/{id}")
	public String deleteCity(@PathVariable int id, Model model) {
		citiesService.deleteCity(id);
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities", cities);
		return "cities";
	}
}
