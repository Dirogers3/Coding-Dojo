package com.ianrogers.lang.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ianrogers.lang.models.Lang;
import com.ianrogers.lang.repositories.LangRepository;

@Service
public class LangService {
private final LangRepository lr;

	public LangService(LangRepository lr) {
		this.lr = lr;
	}
	
	public List<Lang> allLangs() {
		return lr.findAll();
	}
	
	public Lang createLang(Lang l) {
		return lr.save(l);
	}
	
	public void deleteLang(Long id) {
		lr.deleteById(id);
	}
	
	public Lang findLang(Long id) {
		Optional<Lang> optionalLang = lr.findById(id);
		if (optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public Lang updateLang(Long id, String name, String creator, String version) {
		Lang lang = findLang(id);
		lang.setName(name);
		lang.setCreator(creator);
		lang.setVersion(version);
		return lr.save(lang);
	}
	
	public Lang updateLang(Lang l) {
		return lr.save(l);
	}

}
