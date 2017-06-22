package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	public PersonService personService;
	
	@GetMapping({"/", "/index"})
	public String homePage() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login(Model model, Error error, String logout) {
	  /*  if (error != null)
		    model.addAttribute("error", "Your username and password is invalid.");*/
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "addPerson";
	}
	
	@PostMapping("/register/persons")
	public String addPerson(Person person){
		personService.savePerson(person);
		return "redirect:/user/order";
	}
	
	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	
	
}
