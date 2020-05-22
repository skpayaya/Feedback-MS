package com.cg.iter.feedbackmanagementsystem.dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//, cascade=CascadeType.ALL

@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	private String id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;

	@ElementCollection
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "roles")
	private Set<String> roles = new HashSet<>();

	public User() {}

	public User(String id, @NotBlank String username, @NotBlank String password) {

		this.id = id;
		this.username = username;
		this.password = password;

	}
	

	public User(String id, @NotBlank String username, @NotBlank String password,
			 Set<String> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;

		this.roles = roles;
	}

	

	public User(@NotBlank String username, @NotBlank String password, Set<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	

	public User(@NotBlank String username, @NotBlank String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
}
