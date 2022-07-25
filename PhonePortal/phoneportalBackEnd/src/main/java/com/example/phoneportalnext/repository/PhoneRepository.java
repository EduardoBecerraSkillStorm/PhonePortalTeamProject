package com.example.phoneportalnext.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.phoneportalnext.entity.Phones;


@Repository
public interface PhoneRepository extends CrudRepository<Phones, Integer>  {

}
