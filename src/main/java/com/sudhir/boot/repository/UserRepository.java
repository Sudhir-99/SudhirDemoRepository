package com.sudhir.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhir.boot.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

}
