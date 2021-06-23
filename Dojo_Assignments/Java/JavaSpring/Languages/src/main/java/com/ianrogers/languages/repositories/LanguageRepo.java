package com.ianrogers.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ianrogers.languages.models.Language;

public interface LanguageRepo extends CrudRepository<Language, Long> {
	
	List<Language> findAll();

}