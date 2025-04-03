package com.daw.persistance.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistance.entities.Tarea;

public interface TareaRepository extends ListCrudRepository<Tarea, Integer>{
	
}
