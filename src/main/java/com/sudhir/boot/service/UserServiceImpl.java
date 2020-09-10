package com.sudhir.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.boot.model.SpringException;
import com.sudhir.boot.model.Users;
import com.sudhir.boot.repository.UserRepository;

@Service("userservice")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userrepo;

	@Override
	public void save(Users us) {
		userrepo.save(us);
	}

	@Override
	public Optional<Users> get(long id) {
		return userrepo.findById(id);
	}

	@Override
	public List<Users> getlist() {
		return userrepo.findAll();
	}

	@Override
	public String update(Users us) {
		userrepo.saveAndFlush(us);
		return new SpringException(true, "User Sucessfully Updated").toString();
	}

	@Override
	public String delete(long id) {
		userrepo.deleteById(id);
		return new SpringException(true, "User Sucessfully Deleted").toString();
	}

}
