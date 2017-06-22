package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
@RequestMapping("/admin")
public class PersonController {

	@Autowired
	public PersonService personService;
	
	@GetMapping("/persons")
	public String getPersons(Model model) {
		model.addAttribute("persons", personService.findAll());
		return "personList";
	}
	
	@PostMapping("/persons")
	public String addPerson(Person person){
		personService.savePerson(person);
		return "redirect:/admin/persons";
	}

}
