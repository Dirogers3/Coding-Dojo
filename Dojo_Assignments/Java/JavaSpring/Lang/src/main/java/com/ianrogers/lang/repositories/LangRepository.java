package com.ianrogers.lang.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianrogers.lang.models.Lang;


@Repository
public interface LangRepository extends CrudRepository <Lang, Long> {
List<Lang> findAll();
}
