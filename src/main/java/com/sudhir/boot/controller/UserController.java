package com.sudhir.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.boot.model.SpringException;
import com.sudhir.boot.model.Users;
import com.sudhir.boot.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apis")
public class UserController {
	
	@Autowired
	UserService userservices;
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveUser")
	@ExceptionHandler(SpringException.class)
	public String saveUser(@RequestBody Users us) {
		userservices.save(us);
		return new SpringException(true, "Client Sucessfully Added").toString();
	}
	
	@RequestMapping(value = "/getAllUserList", method = RequestMethod.GET, produces = { "application/json" })
	public List<Users> getAllUserList() throws Exception {
		return userservices.getlist();
	}
	
	
	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET,produces = { "application/json" })
	public Optional<Users> getUserById(@PathVariable long id) {
		return userservices.get(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateUser/{id}")
	@ExceptionHandler(SpringException.class)
	public String updateUser(@RequestBody Users us, @PathVariable int id) {
		us.setId(id);
		return userservices.update(us);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return userservices.delete(id);
	}

}
