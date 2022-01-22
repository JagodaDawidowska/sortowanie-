package com.jdawidowska.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jdawidowska.service.model.Logowanie;
import com.jdawidowska.service.services.LogowanieManager;

@RestController
public class LogowanieApi {

	private LogowanieManager logowanieManager;
	
	@Autowired
	public LogowanieApi(LogowanieManager logowanieManager) 
	{
		this.logowanieManager=logowanieManager;
	}
	
	
	//@GetMapping("/PokazWszystkichUzytkownikow")
	Iterable<Logowanie> PokazWszystkichUzytkownikow()
	{
		return logowanieManager.PokazWszystkichuzytkownikow();
		
	};
	
}
