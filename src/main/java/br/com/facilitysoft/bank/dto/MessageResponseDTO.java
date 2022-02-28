package br.com.facilitysoft.bank.dto;

import java.io.Serializable;

public class MessageResponseDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String mensage;

	public MessageResponseDTO(String mensage) {
		super();
		this.mensage = mensage;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}	
	
	
		
}
