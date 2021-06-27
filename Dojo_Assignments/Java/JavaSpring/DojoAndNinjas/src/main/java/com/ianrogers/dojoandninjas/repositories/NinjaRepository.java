package com.ianrogers.dojoandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianrogers.dojoandninjas.models.Dojo;
import com.ianrogers.dojoandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long>{
	List<Ninja> findAll();
	
	List<Ninja> findAllByDojo(Dojo dojo);

}
