package com.PhonePortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Plans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer planID;
	
	@Column
	private String planName;
	
	@Column
	private Integer planPrice;
	
	@OneToOne
	@JoinColumn(name = "userNameID")
    private UserName userName;
}
