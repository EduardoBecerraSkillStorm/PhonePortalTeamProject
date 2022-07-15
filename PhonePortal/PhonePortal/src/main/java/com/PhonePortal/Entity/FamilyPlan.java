package com.PhonePortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class FamilyPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer familyPlanID;
	
	@Column
	private String devicesID;
	
	@Column
	private Integer pricePerLine;
	
	@ManyToOne
	@JoinColumn(name = "userNameID")
    private UserName userName;
	
	
}
