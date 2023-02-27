package br.com.drighi.api.exceptions;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class PersistEqualUserException extends Exception implements Serializable {

	private static final long serialVersionUID = 5702387619459251701L;

	public static final String ID = "id";

	private String message = null;
	private String emailInput = null;
	
	public PersistEqualUserException(String emailInput) {
		this.emailInput = emailInput;
		this.message = String.format("O email informado %s ja existe", emailInput);
	}

}
