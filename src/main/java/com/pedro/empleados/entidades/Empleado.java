package com.pedro.empleados.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {
	
	@Id
	@Column(name="id")
	//@SequenceGenerator(name="IdEmpleadoGenrator", sequenceName="EMPLEADOS_SEQ1")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="IdEmpleadoGenrator")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="edad")
	private int edad;
	@Column(name="correo")
	private String correo;
	
	public Empleado() {
		super();
	}

	public Empleado(int id, String nombre, int edad, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
