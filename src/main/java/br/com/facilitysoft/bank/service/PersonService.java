package br.com.facilitysoft.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.facilitysoft.bank.dto.MensageResponseDTO;
import br.com.facilitysoft.bank.entity.Person;
import br.com.facilitysoft.bank.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;

	public MensageResponseDTO creatPerson(@RequestBody Person person) {
		Person savedPerson = repository.save(person);
		return MensageResponseDTO
				.builder()
				.mensage("Saved Person whith ID " + savedPerson.getId())
				.build();
				
	}

}
