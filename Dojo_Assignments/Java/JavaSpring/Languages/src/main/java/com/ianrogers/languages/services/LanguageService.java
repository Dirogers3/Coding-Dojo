package com.ianrogers.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ianrogers.languages.models.Language;
import com.ianrogers.languages.repositories.LanguageRepo;

@Service
public class LanguageService {
	// Add lang to repo as dependency
	private final LanguageRepo languageRepo;
	
	//Constructor
	public LanguageService(LanguageRepo languageRepo) {
		this.languageRepo = languageRepo;
	}
	//this returns all languages in the database
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}
	//this saves a language into the database.
	public Language createLanguage(Language l) {
		return languageRepo.save(l);
	}
	//This finds a languages by ID
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	// This will update a language thats already in the database
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Language l = findLanguage(id);
		l.setName(name);
		l.setCreator(creator);
		l.setVersion(version);
		return languageRepo.save(l);
	}
	
	//this will delete a language by the id
	public void delete(Long id) {
		languageRepo.deleteById(id);
	}
}
