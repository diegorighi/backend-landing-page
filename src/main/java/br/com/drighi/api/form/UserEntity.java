package br.com.drighi.api.form;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Document("user")
public final class UserEntity extends Person implements Serializable {

	private static final long serialVersionUID = -8494078638146916565L;

	private Boolean isActive = false;
	
	public UserEntity(String nome, String sobrenome, String cpf, 
			String dataNasc, String email, Boolean isActive) {
		super(nome, sobrenome, cpf, dataNasc, email);
		this.isActive = isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
