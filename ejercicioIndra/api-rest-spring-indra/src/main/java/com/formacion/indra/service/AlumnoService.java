package com.formacion.indra.service;

import java.util.List;

import com.formacion.indra.entity.Alumno;





public interface AlumnoService {

	public List<Alumno> findAll();
	
	public Alumno findById(Long id);
	
	public Alumno save(Alumno alumno);
}
