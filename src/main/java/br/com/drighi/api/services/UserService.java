package br.com.drighi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.drighi.api.exceptions.PersistEqualUserException;
import br.com.drighi.api.form.UserEntity;
import br.com.drighi.api.form.UserForm;
import br.com.drighi.api.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional
	public Boolean createUser(UserForm form) {
		Boolean created = false;
		UserEntity entity = convertToEntity(form);
		
		try {
			if(userIsPresent(entity))
				throw new PersistEqualUserException(entity.getEmail());
			else {
				repository.save(entity);
				created = true;
			}
		}catch(PersistEqualUserException peue) {
			peue.getMessage();
		}
		return created;
	}

	public void findAllUsers() {

	}

	public void findUserById() {

	}

	private Boolean userIsPresent(UserEntity record) {
		Boolean isThere = false;
		if (repository.findByEmail(record.getEmail()).isPresent()) {
			isThere = true;
		}
		return isThere;
	}
	
	private UserEntity convertToEntity(UserForm form) {
		return new UserEntity(form.nome(), form.sobrenome(), form.cpf(), form.dataNasc(),
				form.email(), form.isActive());
	}
	

}
