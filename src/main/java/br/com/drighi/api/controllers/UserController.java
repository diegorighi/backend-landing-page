package br.com.drighi.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.drighi.api.exceptions.PersistEqualUserException;
import br.com.drighi.api.form.UserDTO;
import br.com.drighi.api.form.UserForm;
import br.com.drighi.api.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
		
		Boolean userCreated = service.createUser(form);
		
		if(userCreated) {
			URI uri = uriBuilder.path("/user/{id}").buildAndExpand(form.nome()).toUri();
			return ResponseEntity.created(uri).body(new UserDTO(form.nome(), form.sobrenome(), "Criado com sucesso!"));
		}else {
			return ResponseEntity.status(HttpStatus.IM_USED).body(new UserDTO(form.nome(), form.sobrenome(), "Usuario ja existe"));
		}
		
	}
	
	@GetMapping("/{id}")
	public void find(@RequestParam Integer id) {
		
	}
	
	@PatchMapping("/{id}")
	public void updateEmail(@RequestParam Integer id, @RequestBody String email) {
		
	}
	
	@PostMapping("/{id}")
	public void inactivate(@RequestParam Integer id) {
		
	}
	
}
