package com.api.service;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.api.model.UserEntity;




@Service
public class GenerateJwtService {
	
		
	@Autowired 
	JwtEncoder jwtEncoder;
	
	public String tokenValid(UserEntity userEntity) {
		
		JwtClaimsSet.Builder builder = JwtClaimsSet.builder()
				.issuedAt(Instant.now())
				.expiresAt(Instant.now().plusSeconds(100000))
				.subject(userEntity.getName())
				.audience(Arrays.asList(userEntity.getId().toString()))
				.claim("scope", Arrays.asList(userEntity.getRole()));
	
		JwtEncoderParameters parameters = JwtEncoderParameters.from(builder.build());
		return this.jwtEncoder.encode(parameters).getTokenValue();
		
		
	}
}
