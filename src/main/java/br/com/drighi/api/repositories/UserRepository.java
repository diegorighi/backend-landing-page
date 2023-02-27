package br.com.drighi.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.drighi.api.form.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

	Optional<String> findByEmail(String email);
}
