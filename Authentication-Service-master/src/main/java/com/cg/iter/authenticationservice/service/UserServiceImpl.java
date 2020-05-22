package com.cg.iter.authenticationservice.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.entity.request.LoginRequest;
import com.cg.iter.authenticationservice.entity.request.SignupRequest;
import com.cg.iter.authenticationservice.entity.response.JwtResponse;
import com.cg.iter.authenticationservice.repository.UserRepository;
import com.cg.iter.authenticationservice.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtil jwtUtils;
	
	@Override
	public ResponseEntity<?> authenticateUser(@Valid LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(),
												 roles));
	}

	
	

	
	@Override
	public ResponseEntity<?> registerUser(@Valid SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Username is already taken!");
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
				encoder.encode(signUpRequest.getPassword())
							 );

		Set<String> strRoles = signUpRequest.getRoles();
		user.setId((int) userRepository.count());
		user.getRoles().addAll(strRoles);
		System.out.println(strRoles);
		userRepository.save(user);

		return ResponseEntity.ok("User registered successfully!");
	}





	@Override
	public boolean editUser(User user) {
			userRepository.save(user);
			return true;
	}





	@Override
	public boolean deleteUser(User user) {
		userRepository.delete(user);
		return true;
	}

}
