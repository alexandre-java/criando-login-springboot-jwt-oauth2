package com.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.UserEntity;



public interface RegisterUserRepository extends JpaRepository<UserEntity, UUID>{

}
