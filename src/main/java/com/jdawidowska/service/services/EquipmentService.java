package com.jdawidowska.service.services;

import org.springframework.stereotype.Service;

import com.jdawidowska.service.data.entities.Equipment;
import com.jdawidowska.service.data.repos.EquipmentRepository;

@Service
public class EquipmentService {

	private EquipmentRepository equipmentRepo;
	
	public EquipmentService(EquipmentRepository sprzetRepo) {
		this.equipmentRepo=sprzetRepo;
	}
	
	
	//TASMY_RTX,HANTLE_1KG,HANTLE_2KG,HANTLE3KG,STEPPER,
	// PILKI_GIMNASTYCZNE
	//stworz i zapisz sprzet
	
	/*
	 * @EventListener(ApplicationReadyEvent.class) public void fill(){
	 * sprzetRepo.save(new Sprzet(NazwaSprzetu.HANTLE3KG)); sprzetRepo.save(new
	 * Sprzet(NazwaSprzetu.PILKI_GIMNASTYCZNE)); }
	 */
	
	
	//pokaz Sprzet
	public Iterable<Equipment> findAllEquipment(){
		return equipmentRepo.findAll();	
	}

	//wyciagamy z bazy obiekt Equipment na podstawie id,
	//jesli nie znajdzie sie nic w bazie - jest null
	//sprawdzamy czy Equipment jest nullem, a jesli nie to czy jes dostepny (availableAmount > 0)
	//jak tak to wypozyczamy i oddajemy TRUE, jak nie to FALSE
	public boolean lendEquipment(Long id) {
		Equipment eq = equipmentRepo.findById(id).orElse(null);
		if(eq != null && eq.getAvailableAmount() > 0) {
			equipmentRepo.lendEquipment(id);
			return true;
		} else {
			return false;
		}
	}

	public boolean returnEquipment(Long id) {
		Equipment eq = equipmentRepo.findById(id).orElse(null);
		if(eq != null && eq.getAvailableAmount() < eq.getTotalAmount()) {
			equipmentRepo.returnEquipment(id);
			return true;			
		}else {
			return false;
		}
	}
}