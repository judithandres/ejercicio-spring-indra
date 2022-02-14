package com.formacion.indra.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formacion.indra.dao.AlumnoDao;
import com.formacion.indra.entity.Alumno;


@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoDao alumnoDao;
	
	
	//LISTAR ALUMNOS
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		
		return (List<Alumno>)alumnoDao.findAll() ;
	}

	//ENCONTRAR ALUMNOS POR ID
	@Override
	@Transactional(readOnly = true)
	public Alumno findById(Long id) {
		
		return  alumnoDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		
		return alumnoDao.save(alumno);
	}
}
