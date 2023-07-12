package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User createdUser = userService.createUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable int userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@GetMapping("get/all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}

}
