package br.com.facilitysoft.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.facilitysoft.bank.dto.MessageResponseDTO;
import br.com.facilitysoft.bank.dto.PersonDTO;
import br.com.facilitysoft.bank.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@Autowired
	private PersonService service;	
	
	@PostMapping
	public MessageResponseDTO creat(@RequestBody  @Valid PersonDTO personDTO) {		
		return service.creat(personDTO);				
	}
	
	@GetMapping
	public List<PersonDTO> listAll() {
		return service.listAll();
	}
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public MessageResponseDTO deleteById(@PathVariable Long id) {
		return service.deleteBYId(id);
	}
	
	@PutMapping
	public MessageResponseDTO update(@RequestBody  @Valid PersonDTO personDTO) {
		return service.update(personDTO);
	}

}
