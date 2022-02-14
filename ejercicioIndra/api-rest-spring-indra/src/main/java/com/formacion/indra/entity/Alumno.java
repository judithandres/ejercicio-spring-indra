package com.formacion.indra.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(nullable=false)
		private String nombre;
		
		@Column(nullable=false)
		private String apellido;
		
		@Column(nullable=false)
		private String dni;
		
		@Column(nullable=false, unique=true)
		private String email;
		@Column(nullable=false)	
		private int cp;
		@Column(nullable=false)
		private int telefono;
		@Column(nullable=false)
		private String direccion;
		
		private String imagen;
		



		public String getNombre() {return nombre;	}
		public void setNombre(String nombre) {this.nombre = nombre;}
		public String getApellido() {return apellido;}
		public void setApellido(String apellido) {this.apellido = apellido;}
		public String getDni() {return dni;}
		public void setDni(String dni) {this.dni = dni;}
		public String getEmail() {return email;}
		public void setEmail(String email) {this.email = email;}
		public int getCp() {return cp;}
		public void setCp(int cp) {this.cp = cp;}
		public int getTelefono() {return telefono;}
		public void setTelefono(int telefono) {this.telefono = telefono;}
		public String getDireccion() {return direccion;}
		public void setDireccion(String direccion) {this.direccion = direccion;}
		public String getImagen() {return imagen;}
		public void setImagen(String imagen) {this.imagen = imagen;}












		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}

	
	
	
	
	
	
	

