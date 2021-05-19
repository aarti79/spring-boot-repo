package com.example.exception;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "users")
	public ResponseEntity<Iterable<User>> getAllUsers(@RequestHeader("X-API-VERSION") String version) {
		Iterable<User> users = userService.findAllUsers();
		return new ResponseEntity<Iterable<User>>(users, (HttpStatus.OK));
	}

	@GetMapping(value = "v1/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") @Min(4) long id) throws ResourceNotFoundException {
		Optional<User> user = userService.findById(id);
		if (!user.isPresent()) {
			throw new ResourceNotFoundException("User with given id not found");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	// default value
	@GetMapping(value = "v1/users")
	public ResponseEntity<List<User>> getUserByName(@RequestParam(value = "name", defaultValue = "iniyan") String name)
			throws ResourceNotFoundException {
		List<User> user = userService.findByName(name);
		if (user == null) {
			throw new ResourceNotFoundException("User not found");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping(value = "v1/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		userService.deleteUserById(id);
		return new ResponseEntity<>("User with id:" + id + "has been deleted", HttpStatus.OK);
	}

	@PostMapping(value = "v1/users", consumes = { "application/json" })
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		userService.saveUser(user);

		// user.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}
