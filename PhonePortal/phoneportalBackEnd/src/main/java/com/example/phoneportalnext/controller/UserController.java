package com.example.phoneportalnext.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.phoneportalnext.entity.Users;
import com.example.phoneportalnext.repository.UserRepository;


@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	
	//Create User
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/newuser")
	public Users newUser(@RequestBody Users user) {
		return userRepository.save(user);
	}
	

	//Choose a User by id
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/existinguser")
	public Users getByUserbyPassword(@RequestBody Users user) {
		Optional<Users> updateUserOptional = Optional.ofNullable(this.userRepository.findByname(user.getName()));
		if(!updateUserOptional.isPresent()) {
			return null;
		}
		
		Users userFound = updateUserOptional.get();	
		if(!userFound.getPass().equals(user.getPass())) {
			return null;
		}
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	//Choose a User by id
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/existinguser2")
	public Users getByUserbyPassword2(@RequestParam("name") String name,@RequestParam("pass") String pass) {
		Optional<Users> updateUserOptional = Optional.ofNullable(this.userRepository.findByname(name));
		if(!updateUserOptional.isPresent()) {
			return null;
		}
		
		
		Users userFound = updateUserOptional.get();	
		String passInputString = userFound.getPass();
		if(!passInputString.equals(pass)) {
			return null;
		}
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	//Choose a User by id
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getuser")
	public Users getByUser1(@RequestBody Users user) {
		Optional<Users> updateUserOptional = Optional.ofNullable(this.userRepository.findByname(user.getName()));
		if(!updateUserOptional.isPresent()) {
			return null;
		}
		
		Users userFound = updateUserOptional.get();	
	
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	
	//NOT IN PRODUCTION 
	//SetAllUsers
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/allusers")
	public List<Users> findAllUsers() {
		return (List<Users>) userRepository.findAll();
	}
	
	//NOT IN PRODUCTION 
	//Update a user by id
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/edituser")
	public Users updateUser(@RequestBody Users users) {
		Optional<Users> updateUserOptional = Optional.ofNullable(this.userRepository.findByname(users.getName()));
		if(!updateUserOptional.isPresent()) {
			return null;
		}		
		Users userFound = updateUserOptional.get();	
		
		if(users.getName() != null) {
		userFound.setName(users.getName());
		}
		if(users.getPass() != null) {
		userFound.setPass(users.getPass());
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
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/chooseplan")
	public Users choosePlan(@RequestBody Users users) {
		Optional<Users> updateUserOptional = Optional.ofNullable(this.userRepository.findByname(users.getName()));
		if(!updateUserOptional.isPresent()) {
			return null;
		}		
		Users userFound = updateUserOptional.get();	
		
		if(users.getPlan_name() != null) {
			if(users.getPlan_name().equals("STANDARD")) {
				userFound.setMonthly_price(45);
			}
			if(users.getPlan_name().equals("FAMILY")) {
				userFound.setMonthly_price(35);
			}
			if(users.getPlan_name().equals("ULTIMATE")) {
				userFound.setMonthly_price(65);
			}
		userFound.setPlan_name(users.getPlan_name());
		}
		
		this.userRepository.save(userFound);
		return userFound;
	}
	
	
	
	//Finish updating standard plan
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/standard")
	public Users standard(@RequestBody Users users) {
		Optional<Users> updateUserOptional = Optional.ofNullable(this.userRepository.findByname(users.getName()));
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
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/family")
	public Users family(@RequestBody Users users) {
		Optional<Users> updateUserOptional = Optional.ofNullable(this.userRepository.findByname(users.getName()));
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
	
	//Finish updating ultimate plan
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/ultimate")
	public Users ultimate(@RequestBody Users users) {
		Optional<Users> updateUserOptional = Optional.ofNullable(this.userRepository.findByname(users.getName()));
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
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/delete")
	public Users deleteUser(@RequestBody Users users) {
		Optional<Users> deleteOptional = Optional.ofNullable(this.userRepository.findByname(users.getName()));
		if(!deleteOptional.isPresent()) {
			return null;	
		}
		Users userToDelete = deleteOptional.get();
		this.userRepository.delete(userToDelete);
		return userToDelete;
	}
	

}




