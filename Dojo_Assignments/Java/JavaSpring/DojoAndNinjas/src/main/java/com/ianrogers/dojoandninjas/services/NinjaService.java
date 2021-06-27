package com.ianrogers.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianrogers.dojoandninjas.models.Dojo;
import com.ianrogers.dojoandninjas.models.Ninja;
import com.ianrogers.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
@Autowired
private NinjaRepository ninjaRepo;



//CRUD
	//create ninja
	public void createNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
	//read all
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	//read just one ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public List findAllByDojo(Dojo dojo) {
		return ninjaRepo.findAllByDojo(dojo);
	}
	
	//update one ninja
	public Ninja updateNinja(Long id, String firstname, String lastname, int age, Dojo dojo) {
		Ninja ninja = findNinja(id);
		ninja.setFirstname(firstname);
		ninja.setLastname(lastname);
		ninja.setAge(age);
		ninja.setDojo(dojo);
		return ninjaRepo.save(ninja);
	}
	
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	
	
}
