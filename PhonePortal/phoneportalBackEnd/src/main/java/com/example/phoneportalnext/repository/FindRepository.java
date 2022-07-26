package com.example.phoneportalnext.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.phoneportalnext.entity.Users;

public interface FindRepository extends CrudRepository<Users, Integer> {
	

	
}
