package com.formacion.indra.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.formacion.indra.entity.Alumno;
import com.formacion.indra.service.AlumnoService;



@RestController
@RequestMapping("/api")
public class AlumnoController {

	@Autowired
	private AlumnoService servicio;
	
	
	// LISTAR ALUMNOS
	@GetMapping("/alumnos")
	public List<Alumno> alumno (){
		return servicio.findAll();
	}
	
	//BUSQUEDA POR ID
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> alumnoShow(@PathVariable Long id){
		Alumno alumno = null;
		
		Map<String,Object> response = new HashMap<>();
		try  {
			alumno = servicio.findById(id);
		}catch (DataAccessException e){
			response.put("mensaje", "Error al relizar busqueda de id");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		if(alumno == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Alumno>(alumno,HttpStatus.OK);
	}
	
	//	INSERCCION DE ALUMNOS
	
	//INSERTACION DE CLIENTES
			@PostMapping("/alumnos")
			@ResponseStatus(HttpStatus.CREATED)
			public ResponseEntity<?> saveAlumno(@RequestBody Alumno alumno) {
				
				Alumno alumnoNew = null;
				
				Map<String,Object> response = new HashMap<>();
				
				try {
					alumnoNew = servicio.save(alumno);
				} catch(DataAccessException e) {
					response.put("mensaje", "Error al realizar insert a la base de datos");
					response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
				response.put("mensaje", "El alumno ha sido creado con éxito :D");
				response.put("cliente", alumnoNew);
				
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
			}
	
	
	
	
}
