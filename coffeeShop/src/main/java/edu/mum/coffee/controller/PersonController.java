package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	public PersonService personService;
	
	public Person savePerson(Person person) {
		return personService.savePerson(person);
	}

	public List<Person> getPersonByEmail(String email) {
		return personService.getPersonByEmail(email);
	}

	public Person getPerson(Long id) {
		return personService.getPerson(id);
	}

	public void removePerson(Person person) {
		personService.removePerson(person);
	}

}
