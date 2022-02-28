package br.com.facilitysoft.bank.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.facilitysoft.bank.dto.PersonDTO;

@Entity
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@CPF
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Email
	@Column(nullable = false, unique = true)
	private String email;
	
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;


	public Person(String name, @CPF String cpf, @Email String email, LocalDate birthDate) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	public Person(PersonDTO personDTO) {
		super();
		this.id = personDTO.getId();
		this.name = personDTO.getName();
		this.cpf = personDTO.getCpf();
		this.email = personDTO.getEmail();
		this.birthDate = personDTO.getBirthDate();
	}
	
	
	public Person() {
		
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}	

		
}
