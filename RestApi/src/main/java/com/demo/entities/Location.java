package com.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name="address")

public class Location{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="addressId")
	private Long addressId;
	
	@Column(name="city")
	private String city;
	
	@Column(name="addresstype")
	private String addresstype;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="locationId")
	private Location location;
	

}