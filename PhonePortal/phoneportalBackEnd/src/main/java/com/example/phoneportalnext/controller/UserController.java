package com.example.phoneportalnext.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.phoneportalnext.entity.Users;
import com.example.phoneportalnext.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//Create User
	@PostMapping("/newuser")
	public Users newUser(@RequestBody Users user) {
		return userRepository.save(user);
	}
	
	//Choose plan by id
	@GetMapping("/getuser/{id}")
	public Users getUser(@PathVariable("id") Integer id) {
		Optional<Users> updateUserOptional = this.userRepository.findById(id);
		if(!updateUserOptional.isPresent()) {
			return null;
		}		
		Users userFound = updateUserOptional.get();	
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	//NOT IN PRODUCTION 
	//SetAllUsers
	@GetMapping("/allusers")
	public List<Users> findAllUsers() {
		return (List<Users>) userRepository.findAll();
	}
	
	//NOT IN PRODUCTION 
	//Update a user by id
	@PutMapping("/user/{id}")
	public Users updateUser(@PathVariable("id") Integer id, @RequestBody Users users) {
		Optional<Users> updateUserOptional = this.userRepository.findById(id);
		if(!updateUserOptional.isPresent()) {
			return null;
		}		
		Users userFound = updateUserOptional.get();	
		
		if(users.getUser_name() != null) {
		userFound.setUser_name(users.getUser_name());
		}
		if(users.getPass_word() != null) {
		userFound.setPass_word(users.getPass_word());
		}
		if(users.getPlan_name() != null) {
		userFound.setPlan_name(users.getPlan_name());
		}
		
		if(users.getMonthly_price() != null) {
		userFound.setMonthly_price(users.getMonthly_price());
		}
		
		if(users.getPhone_number_1() != null) {
		userFound.setPhone_number_1(users.getPhone_number_1());
		}
		
		if(users.getDevice_name_1() != null) {
		userFound.setDevice_name_1(users.getDevice_name_1());
		}
		
		if(users.getPhone_number_2() != null) {
		userFound.setPhone_number_2(users.getPhone_number_2());
		}
		
		if(users.getDevice_name_2() != null) {
		userFound.setDevice_name_2(users.getDevice_name_2());
		}
		
		if(users.getPhone_number_3() != null) {
		userFound.setPhone_number_3(users.getPhone_number_3());
		}
		
		if(users.getDevice_name_3() != null) {
		userFound.setDevice_name_3(users.getDevice_name_3());
		}
		
		if(users.getPhone_number_4() != null) {
		userFound.setPhone_number_4(users.getPhone_number_4());
		}
		
		if(users.getDevice_name_4() != null) {
		userFound.setDevice_name_4(users.getDevice_name_4());
		}
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	//Choose plan by id
	@PutMapping("/chooseplan/{id}")
	public Users choosePlan(@PathVariable("id") Integer id, @RequestBody Users users) {
		Optional<Users> updateUserOptional = this.userRepository.findById(id);
		if(!updateUserOptional.isPresent()) {
			return null;
		}		
		Users userFound = updateUserOptional.get();	
		
		if(users.getPlan_name() != null) {
			if(users.getPlan_name().equals("STANDARD")) {
				userFound.setMonthly_price(45);
			}
			if(users.getPlan_name() == "FAMILY") {
				userFound.setMonthly_price(35);
			}
			if(users.getPlan_name() == "ULTIMATE") {
				userFound.setMonthly_price(65);
			}
		userFound.setPlan_name(users.getPlan_name());
		}
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	
	
	//Finish updating standard plan
	@PutMapping("/standard/{id}")
	public Users standard(@PathVariable("id") Integer id, @RequestBody Users users) {
		Optional<Users> updateUserOptional = this.userRepository.findById(id);
		if(!updateUserOptional.isPresent()) {
			return null;
		}		
		Users userFound = updateUserOptional.get();	
		
		if(users.getPhone_number_1() != null) {
		userFound.setPhone_number_1(users.getPhone_number_1());
		}
		
		if(users.getDevice_name_1() != null) {
		userFound.setDevice_name_1(users.getDevice_name_1());
		}
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	//Finish updating plan
	@PutMapping("/family/{id}")
	public Users family(@PathVariable("id") Integer id, @RequestBody Users users) {
		Optional<Users> updateUserOptional = this.userRepository.findById(id);
		if(!updateUserOptional.isPresent()) {
			return null;
		}		
		Users userFound = updateUserOptional.get();	
		
		if(users.getPhone_number_1() != null) {
		userFound.setPhone_number_1(users.getPhone_number_1());
		}
		
		if(users.getDevice_name_1() != null) {
		userFound.setDevice_name_1(users.getDevice_name_1());
		}
		
		if(users.getPhone_number_2() != null) {
		userFound.setPhone_number_2(users.getPhone_number_2());
		}
		
		if(users.getDevice_name_2() != null) {
		userFound.setDevice_name_2(users.getDevice_name_2());
		}
		
		if(users.getPhone_number_3() != null) {
		userFound.setPhone_number_3(users.getPhone_number_3());
		}
		
		if(users.getDevice_name_3() != null) {
		userFound.setDevice_name_3(users.getDevice_name_3());
		}
		
		if(users.getPhone_number_4() != null) {
		userFound.setPhone_number_4(users.getPhone_number_4());
		}
		
		if(users.getDevice_name_4() != null) {
		userFound.setDevice_name_4(users.getDevice_name_4());
		}
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	//Finish updating utilmate plan
	@PutMapping("/ultimate/{id}")
	public Users ultimate(@PathVariable("id") Integer id, @RequestBody Users users) {
		Optional<Users> updateUserOptional = this.userRepository.findById(id);
		if(!updateUserOptional.isPresent()) {
			return null;
		}		
		Users userFound = updateUserOptional.get();	
		
		if(users.getPhone_number_1() != null) {
		userFound.setPhone_number_1(users.getPhone_number_1());
		}
		
		if(users.getDevice_name_1() != null) {
		userFound.setDevice_name_1(users.getDevice_name_1());
		}
		
		this.userRepository.save(userFound);
		return userFound;
	}
	

	
	//@Delete a user by ID
	@DeleteMapping("/delete/{id}")
	public Users deleteUser(@PathVariable("id") Integer id) {
		Optional<Users> deleteOptional = this.userRepository.findById(id);
		if(!deleteOptional.isPresent()) {
			return null;	
		}
		Users userToDelete = deleteOptional.get();
		this.userRepository.delete(userToDelete);
		return userToDelete;
	}
	

}




