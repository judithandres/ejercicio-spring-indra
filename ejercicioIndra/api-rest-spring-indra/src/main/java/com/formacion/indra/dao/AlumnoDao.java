package com.formacion.indra.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.formacion.indra.entity.Alumno;

@Repository
public interface AlumnoDao extends CrudRepository <Alumno, Long>{



	
	
}
