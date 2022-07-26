package com.example.phoneportalnext.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.phoneportalnext.entity.Users;

public interface FindRepository extends CrudRepository<Users, Integer> {
	

	
}
