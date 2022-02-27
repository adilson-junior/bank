package br.com.facilitysoft.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.facilitysoft.bank.dto.MensageResponseDTO;
import br.com.facilitysoft.bank.entity.Person;
import br.com.facilitysoft.bank.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public String getPeople() {
		return "API WORK";
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MensageResponseDTO creatPerson(@RequestBody Person person) {		
		return service.creatPerson(person);				
	}

}
