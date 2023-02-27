package br.com.drighi.api.form;

public record UserForm(
		String nome, 
		String sobrenome, 
		String cpf, 
		String dataNasc, 
		String email, 
		Boolean isActive) {}
