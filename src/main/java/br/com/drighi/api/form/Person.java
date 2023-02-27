package br.com.drighi.api.form;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public sealed abstract class Person permits UserEntity {

	private String nome;
	private String sobrenome;
	
	@Id
	private String cpf;
	private String dataNasc;
	private String email;
	
}
