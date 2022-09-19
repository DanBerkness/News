package com.danielberkness.news.repository;

import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.tokens.Token.ID;

import com.danielberkness.news.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
	Optional<User> findById(Long id);
	
	User getReferenceById(ID id);
}
