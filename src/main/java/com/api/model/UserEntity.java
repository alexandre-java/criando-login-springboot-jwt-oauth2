package com.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_USER")
public class UserEntity implements UserDetails,Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false,nullable = false)
	private UUID id;
	

    @Column(length = 255, nullable = false)
    private String name;
	
	
	
	
    @Column(length = 255, nullable = false)
	private String password;
	
	
    @Column(length = 255, nullable = false , unique = true)
   
	private String email;
	
	
	
    @Column(length = 15, nullable = false , unique = true)
	private String fone;
	
	
    @Column(length = 255, nullable = false)
	private String role;
	

	
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		 if(this.role.equals("ADMIN")){ 
				return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
	        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	    }
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	

}
