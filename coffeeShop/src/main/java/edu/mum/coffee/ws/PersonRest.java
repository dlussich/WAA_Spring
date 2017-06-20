package edu.mum.coffee.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonRest {
	
	@Autowired
	public PersonService personService;
	
	@GetMapping()
	public @ResponseBody List<Person> getPersons(){
		return personService.findAll();
	}
	
	@GetMapping(value="/email/{email}")
	public @ResponseBody List<Person> getByEmail(@PathVariable String email){
		return personService.getPersonByEmail(email);
	}
	
	@GetMapping(value="/{id}")
	public Person getPerson(@PathVariable long id){
		return personService.getPerson(id);
	}
	
	@PostMapping()
	public Person createPerson(@RequestBody Person person){
		return personService.savePerson(person);
	}
	
	@PutMapping(value="/update/{id}")
	public Person updatePerson(@PathVariable long id, @RequestBody Person person){
		Person objPerson = personService.getPerson(id);
		objPerson.setAddress(person.getAddress());
		objPerson.setEmail(person.getEmail());
		objPerson.setEnable(person.isEnable());
		objPerson.setFirstName(person.getFirstName());
		objPerson.setLastName(person.getLastName());
		objPerson.setPhone(person.getPhone());
		return personService.savePerson(objPerson);
	}
	
	

}
