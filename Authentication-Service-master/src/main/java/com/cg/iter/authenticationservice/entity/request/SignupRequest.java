package com.cg.iter.authenticationservice.entity.request;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class SignupRequest {

	@NotBlank
    private String username;
 
    private Set<String> roles = new HashSet<>();
    
    @NotBlank
    private String password;
    
    public String getUsername() {
        return username;
    }
 
    
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRoles() {
      return this.roles;
    }
    
    public SignupRequest(@NotBlank String username, @NotBlank String password, Set<String> roles) {
		super();
		this.username = username;
		this.roles = roles;
		this.password = password;
	}


	public void setRoles(Set<String> role) {
      this.roles.addAll(role);
    }
    
}
