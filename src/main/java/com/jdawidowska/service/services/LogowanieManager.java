package com.jdawidowska.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.jdawidowska.service.data.repos.LogowanieRepo;
import com.jdawidowska.service.model.Logowanie;

@Service
public class LogowanieManager {
	
	private LogowanieRepo logowanieRepo;
	
	@Autowired
	public LogowanieManager(LogowanieRepo logowanieRepo) {
		this.logowanieRepo=logowanieRepo;
		
	}
	
	
	
	//Stworz i zapisz Uzytkownikow
	 @EventListener(ApplicationReadyEvent.class)
	void Zapisz()
	{
		logowanieRepo.save(new Logowanie("jagoda","23424"));
		logowanieRepo.save(new Logowanie("ewrwre","23424"));
		logowanieRepo.save(new Logowanie("wwww","23wer24"));
	}
	
	 
	 //pokaz 
		public Iterable<Logowanie> PokazWszystkichuzytkownikow()
		{
			return logowanieRepo.findAll();
			
		};


}
