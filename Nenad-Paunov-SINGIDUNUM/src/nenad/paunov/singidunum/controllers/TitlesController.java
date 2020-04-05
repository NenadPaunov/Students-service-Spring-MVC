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

import nenad.paunov.singidunum.entities.Title;
import nenad.paunov.singidunum.services.TitlesService;

@Controller
public class TitlesController {
	@Autowired
	private TitlesService titlesService;
	
	@RequestMapping("/titles")
	public String showTitles(Model model) {
		List<Title> titles = titlesService.getAllTitles();
		model.addAttribute("titles",titles);
		return "titles";		
	}
	
	@RequestMapping("/create_title")
	public String createTitle(Model model){	
		return "create_title";
	}
	@RequestMapping(value="/docreatetitle", method=RequestMethod.POST)
	public String doCreate(Model model,@Valid Title title, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError e: errors) {
				System.out.println(e.getDefaultMessage());
			return "create_title";
			}
		}else {
			System.out.println("Form validated successsfully!");			
		}
		
		titlesService.saveOrUpdateTitle(title);
		model.addAttribute("title",title);
		return "title_created";
	}
	
	@RequestMapping(value ="/doupdatetitle/{titleId}")
	public String updateTitle(@PathVariable int titleId, Model model) {
		Title title = titlesService.getTitle(titleId);
		model.addAttribute("title", title);
		model.addAttribute("id", titleId);
		return "update_title";
	}
	
	@RequestMapping(value = "/updatetitle/{titleId}", method = RequestMethod.POST)
	public String doUpdate(@PathVariable int titleId, Model model,@Valid Title title, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form is not valid");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError e: errors) {
				System.out.println(e.getDefaultMessage());
			return "update_title";
			}
		}else {
			System.out.println("Form validated successsfully!");			
		}
		
		titlesService.saveOrUpdateTitle(title);
		model.addAttribute("title",title);
		return "title_created";
	}
	
	@RequestMapping(value ="/dodeletetitle/{id}")
	public String deleteTitle(@PathVariable int id, Model model) {
		titlesService.deleteTitle(id);
		List<Title> titles = titlesService.getAllTitles();
		model.addAttribute("titles", titles);
		return "titles";
	}
}
