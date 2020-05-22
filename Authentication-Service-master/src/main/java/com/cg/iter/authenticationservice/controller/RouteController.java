package com.cg.iter.authenticationservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/app/route")
public class RouteController {

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	@GetMapping("/student")
	@PreAuthorize("hasRole('STUDENT')")
	public String userAccess() {
		
		return "User Content.";
	}
	@GetMapping("/coordinator")
	@PreAuthorize("hasRole('COORDINATOR')")
	public String coordinatorAccess() {
		return "Coordinator Board.";
	}
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
