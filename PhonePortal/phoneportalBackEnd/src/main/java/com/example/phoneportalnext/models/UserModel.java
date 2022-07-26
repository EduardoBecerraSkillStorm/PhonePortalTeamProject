package com.example.phoneportalnext.models;

import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.phoneportalnext.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
public class UserModel extends Users {
	
	@Autowired
	Users user;
	
	@Column
	private String user_name;
	@Column
	private String pass_word;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	
	

}
