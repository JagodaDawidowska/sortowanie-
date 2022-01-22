package com.jdawidowska.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
@ToString
@Getter
@Setter


public class Logowanie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String userName;
	String password;
	

	
	
	public Logowanie(String userName, String password) 
	{
		this.userName=userName;
		this.password=password;
		
	}
	

}
