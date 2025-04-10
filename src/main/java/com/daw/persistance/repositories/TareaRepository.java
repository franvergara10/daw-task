package com.daw.persistance.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistance.entities.Tarea;
import com.daw.persistance.entities.enums.Estado;

public interface TareaRepository extends ListCrudRepository<Tarea, Integer> {

	//Obtener el número total de tareas completadas.
	/*
	 * 	SELECT count(*)
	 * 	FROM tarea
	 * 	WHERE estado = ?1
	 */
	long countByEstado(Estado estado);
	
	List<Tarea> findByEstado(Estado estado);
	
	//Obtener las tareas vencidas.
	List<Tarea> findByFechaVencimientoBefore(LocalDate fecha);
	
	//Obtener las tareas no vencidas
	List<Tarea> findByFechaVencimientoAfter(LocalDate fecha);
	
	//Obtener las tareas ordenadas por fecha de vencimiento.
	List<Tarea> findAllByOrderByFechaVencimiento();
	
	
	
	
	
	
	
	
	
		
}