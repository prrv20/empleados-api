package com.pedro.empleados.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.empleados.dao.EmpleadoDAO;
import com.pedro.empleados.entidades.Empleado;

@RestController
@RequestMapping("empleados")
public class EmpleadoRest {
	
	@Autowired
	private EmpleadoDAO empdao;
	
	//Metodo que devuelve la lista de todos los Empleados
	@GetMapping
	public ResponseEntity<List<Empleado>> verEmpleado(){
		List<Empleado> empleados = empdao.findAll();
		return ResponseEntity.ok(empleados);
	}
	
	//Metodo que devuelve un Empleado buscado por Id
		@RequestMapping(value= "{id}")
		public ResponseEntity<Empleado> verEmpleadoById(@PathVariable("id") Integer Id){
			
			Optional<Empleado> optionalempleado= empdao.findById(Id);
			if (optionalempleado.isPresent()) {
				return ResponseEntity.ok(optionalempleado.get());
			} else {
				return ResponseEntity.noContent().build();
			}		
		}
		
		//Metodo para Crear un Registro
		@PostMapping  // url:/empleados(POST)
		public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){
			Empleado newEmpleado = empdao.save(empleado);
			return ResponseEntity.ok(newEmpleado);
		}
		
		//Metodo para Eliminar un Registro
		@DeleteMapping(value = "{id}") // url:/empleados(DELETE)
		public ResponseEntity<Void> borrarEmpleado(@PathVariable("id") Integer Id) {
			empdao.deleteById(Id);
			return ResponseEntity.ok(null);
		}
		//Metodo para Actualizar un Registro
		@PutMapping
		public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado){
			Optional<Empleado> optionalempleado= empdao.findById(empleado.getId());
			if (optionalempleado.isPresent()) {
				Empleado newEmp = optionalempleado.get();
				newEmp.setNombre(empleado.getNombre());
				newEmp.setEdad(empleado.getEdad());
				newEmp.setCorreo(empleado.getCorreo());
				empdao.save(newEmp);
				return ResponseEntity.ok(newEmp);
			} else {
				return ResponseEntity.notFound().build();
			}	
		}
	
	//Probando las URL
//	//@GetMapping//Este metodo tomo como url la raiz "/". Localhost:8080/
//	@RequestMapping(value="/hola", method=RequestMethod.GET)//con este metodo podemos asignarle la url personalizada. Localhost:8080/hola
//	public String hola() {
//		return "Hola Mundo Practicando Servicios Rest";
//	}
}
