package com.mySpringPorject.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

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
public class UserResourceController {
	
	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Integer id){
		User savedUser =  userDaoService.findOne(id);
		
		if(savedUser==null) {
			throw new UserNotFoundException("id -"+ id);
		}
		return savedUser;
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUsers(@Valid @RequestBody User user){
		User savedUser = userDaoService.save(user);	
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		User user =  userDaoService.deleteById(id);
		
		if(user==null) {
			throw new UserNotFoundException("id -"+ id);
		}
	}

	
}
