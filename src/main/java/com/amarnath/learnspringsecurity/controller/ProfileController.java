package com.amarnath.learnspringsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amarnath.learnspringsecurity.classes.Profiles;
import com.amarnath.learnspringsecurity.repository.ProfileRepository;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileRepository repo;
	
	
	
	public ProfileController(ProfileRepository repo) {
		super();
		this.repo = repo;
	}



	@GetMapping("/profiles")
	//@PreAuthorize("hasRole('ADMIN')")
	private List<Profiles> GetAllProfiles(){
		
		return repo.getAllProfiles();
		
	}
	
	@GetMapping("/profiles/user/{username}")
	private Profiles GetUser(@PathVariable String username) {
		
		return repo.getUser(username);
		
	}
	
	@PostMapping("/profiles/user")
	private void AddUser(@RequestBody Profiles body) {
		
		repo.addUser(body);
		
	}

}
