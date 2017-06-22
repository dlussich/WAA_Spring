package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		List<Person> person=personService.getPersonByEmail(email);
		model.addAttribute("user",person.get(0));
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
		return "home";
	}
	
	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	
	
}
