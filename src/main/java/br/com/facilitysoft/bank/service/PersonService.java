package br.com.facilitysoft.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.facilitysoft.bank.dto.MessageResponseDTO;
import br.com.facilitysoft.bank.dto.PersonDTO;
import br.com.facilitysoft.bank.entity.Person;
import br.com.facilitysoft.bank.exception.DataIntegrityViolationException;
import br.com.facilitysoft.bank.exception.ObjectNotFoundException;
import br.com.facilitysoft.bank.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;

	public MessageResponseDTO creat(PersonDTO personDTO) {
		//Por garantia o id é setado como null, para evitar erros
		personDTO.setId(null);
		//Valida o CPF e EMAIL
		validaPorCpfEEmail(personDTO);
		Person personToSave = new Person(personDTO);
		Person person = repository.save(personToSave);
		return creatMessageResponse(person.getId(), "Created person with ID ");
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = repository.findAll();
		List<PersonDTO> allPeopleDTO = allPeople.stream().map(p -> new PersonDTO(p)).collect(Collectors.toList());		
		return allPeopleDTO;
	}
		
	public PersonDTO findById(Long id) {
		PersonDTO personDTO = new PersonDTO(verifyByExists(id));
		return personDTO;
	}
	
	public MessageResponseDTO deleteBYId(Long id) {		
		verifyByExists(id);
		repository.deleteById(id);
		return creatMessageResponse(id, "Deleted Person whith ID  ");			
	}
	
    public MessageResponseDTO update(PersonDTO personDTO) {
    	verifyByExists(personDTO.getId());
		Person personToUpdate = new Person(personDTO);
		Person updatedPerson = repository.save(personToUpdate);		
		return creatMessageResponse(updatedPerson.getId(), "Updated person with ID ");
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
	
	//Metodo para verificar a existencia do objeto
	public Person verifyByExists(Long id) {
		Optional<Person> person = repository.findById(id);		
		return person.orElseThrow(() -> new ObjectNotFoundException("Object not found with id "+ id));
	}
	
	//Método para criar uma mensagem de retorno
	private MessageResponseDTO creatMessageResponse(Long id, String message) {
		return new MessageResponseDTO(message+id);
	}
	
}
