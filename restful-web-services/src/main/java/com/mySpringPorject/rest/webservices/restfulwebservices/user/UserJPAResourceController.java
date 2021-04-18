package com.mySpringPorject.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResourceController {

	@Autowired
	UserJPAResourceRepo userJPAResource;

	@Autowired
	PostJPAResourceRepo postJPAResource;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userJPAResource.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {
		Optional<User> savedUser = userJPAResource.findById(id);

		if (savedUser.isEmpty()) {
			throw new UserNotFoundException("id -" + id);
		}
		return savedUser.get();
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> addUsers(@Valid @RequestBody User user) {
		User savedUser = userJPAResource.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userJPAResource.deleteById(id);
	}

	// getting post for a user

	@GetMapping("/jpa/users/{id}/post")
	public List<Post> retrieveUserPost(@PathVariable Integer id) {
		Optional<User> userOptional = userJPAResource.findById(id);
		if (userOptional.isEmpty()) {
			throw new UserNotFoundException("id -" + id);
		} else {
			return userOptional.get().getPost();
		}
	}

	// Inserting Post for a User

	@PostMapping("/jpa/users/{id}/post")
	public ResponseEntity<Object> addUsersPost(@PathVariable Integer id, @RequestBody Post post) {
		Optional<User> savedUser = userJPAResource.findById(id);

		if (savedUser.isEmpty()) {
			throw new UserNotFoundException("id -" + id);
		}

		User user = savedUser.get();
		post.setUser(user);
		postJPAResource.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}
