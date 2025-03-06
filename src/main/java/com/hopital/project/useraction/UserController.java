package com.hopital.project.useraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hopital.project.repository.UserRepository;
import com.hopital.project.tables.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
