package com.apitestjava.apitestserver.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apitestjava.apitestserver.Models.User;

public interface UserRepo extends JpaRepository<User, Long>{
    
}
