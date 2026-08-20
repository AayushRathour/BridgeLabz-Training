package com.aayush.fundoo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "users")
@Getter 
@Setter
// Maps one application user to one row in the users database table.
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	
	@Column(unique = true, nullable =false)
	private String email;
	
	private String password;
	
	private String resetToken;
	private Long resetTokenExpiry;
	
}
