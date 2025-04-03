package com.daw.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistance.entities.Tarea;
import com.daw.persistance.entities.enums.Estado;
import com.daw.persistance.repositories.TareaRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;

	public List<Tarea> finAll() {
		return this.tareaRepository.findAll();

	}
	
	public Tarea findById(int idTarea) {
		
		return this.tareaRepository.findById(idTarea).get();	
	}
	
	public boolean existById(int idTarea) {
		return this.tareaRepository.existsById(idTarea);
	}
	
	public boolean deleteById(int idTarea) {
		boolean result=false;
		if(this.tareaRepository.existsById(idTarea)) {
			this.tareaRepository.deleteById(idTarea);
			result=true;
		}
		return result;
	}
	
	public Tarea create (Tarea tarea) {
		tarea.setFechaCreacion(LocalDate.now());
		tarea.setEstado(Estado.PENDIENTE);
		
		return this.tareaRepository.save(tarea);
	}
	
	public Tarea update (Tarea tarea) {
		Tarea tareaBD = this.findById(tarea.getId());
		tarea.setFechaCreacion(tareaBD.getFechaCreacion());
		tarea.setEstado(tareaBD.getEstado());
		
		return this.tareaRepository.save(tarea);
		
	}
	

}
