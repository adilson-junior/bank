package br.com.facilitysoft.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.facilitysoft.bank.dto.MensageResponseDTO;
import br.com.facilitysoft.bank.dto.PersonDTO;
import br.com.facilitysoft.bank.entity.Person;
import br.com.facilitysoft.bank.exception.DataIntegrityViolationException;
import br.com.facilitysoft.bank.exception.ObjectNotFoundException;
import br.com.facilitysoft.bank.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;

	public MensageResponseDTO creatPerson(@RequestBody PersonDTO personDTO) {
		//Por garantia o id é setado como null, para evitar erros
		personDTO.setId(null);
		//Valida o CPF e EMAIL
		validaPorCpfEEmail(personDTO);
		Person savedPerson = new Person(personDTO);
		repository.save(savedPerson);
		MensageResponseDTO resposta = new MensageResponseDTO("Saved Person whith ID " + savedPerson.getId());
		return resposta;
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = repository.findAll();
		List<PersonDTO> allPeopleDTO = allPeople.stream().map(p -> new PersonDTO(p)).collect(Collectors.toList());		
		return allPeopleDTO;
	}
		
	public Person findById(Long id) {
		Optional<Person> person = repository.findById(id);		
		return person.orElseThrow(() -> new ObjectNotFoundException("Object not found with id "+ id));
	}
	
	public void deleteBYId(Long id) {		
		findById(id);
		repository.deleteById(id);		
	}
	
	//Métodos para validações
	private void validaPorCpfEEmail(PersonDTO objDTO) {
		Optional<Person> obj = repository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}

		obj = repository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}	

}
