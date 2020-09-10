package com.sudhir.boot.service;

import java.util.List;
import java.util.Optional;

import com.sudhir.boot.model.Users;

public interface UserService {
	
	void save(Users us);
	
	Optional<Users> get(long id);
	
	List<Users> getlist();
	
	String update(Users fc);

	String delete(long id);

}
