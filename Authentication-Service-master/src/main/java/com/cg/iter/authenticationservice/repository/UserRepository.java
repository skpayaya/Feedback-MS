package com.cg.iter.authenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.authenticationservice.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

}