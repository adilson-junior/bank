package br.com.facilitysoft.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.facilitysoft.bank.dto.MensageResponseDTO;
import br.com.facilitysoft.bank.dto.PersonDTO;
import br.com.facilitysoft.bank.entity.Person;
import br.com.facilitysoft.bank.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@Autowired
	private PersonService service;	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MensageResponseDTO creatPerson(@RequestBody PersonDTO personDTO) {		
		return service.creatPerson(personDTO);				
	}
	
	@GetMapping
	public List<PersonDTO> listAll() {
		return service.listAll();
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		service.deleteBYId(id);
	}

}
