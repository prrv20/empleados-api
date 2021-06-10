package com.pedro.empleados.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.empleados.entidades.Empleado;

public interface EmpleadoDAO extends JpaRepository<Empleado, Integer>{

	List<Empleado> findAll();
	
}
