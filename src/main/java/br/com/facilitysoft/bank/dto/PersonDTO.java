package br.com.facilitysoft.bank.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.facilitysoft.bank.entity.Person;

public class PersonDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 100)
	private String name;
	
	@NotNull
	@CPF
	private String cpf;
	
	@NotNull
	@Email
	private String email;	
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;

	public PersonDTO(@NotNull @Size(min = 2, max = 100) String name, @NotNull @CPF String cpf,
			@NotNull @Email String email, @NotNull LocalDate birthDate) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	public PersonDTO(Person obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.birthDate = obj.getBirthDate();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

}
