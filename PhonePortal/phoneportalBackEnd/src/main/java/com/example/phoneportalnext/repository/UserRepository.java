package com.example.phoneportalnext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.phoneportalnext.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>  {
	
	Users findByname(String name);

}
