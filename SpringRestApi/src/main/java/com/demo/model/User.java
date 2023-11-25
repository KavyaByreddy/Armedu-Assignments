package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_email")
	private String email;

	
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="addressId")
private List<Address> address=new ArrayList<>();
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;*/
	

}