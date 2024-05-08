package com.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.model.UserEntity;



@EnableJpaRepositories
public interface LoginValidUserExistingRepository extends JpaRepository<UserEntity, UUID>{
	UserDetails findByEmail(String email);
}
