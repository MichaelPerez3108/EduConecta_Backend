package com.educonecta.app.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Usuario;
import com.educonecta.app.service.IUsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="API de Usuarios", description="Controlador para la gestion de usuarios.")
@RestController
@RequestMapping(value="ApiUsers")
public class UsuarioController {
	
	@Autowired
	IUsuarioService servicio;
	
	@Operation(summary="Este endpoint permite crear o registrar un usuario.")
	@PostMapping(value="registrar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarUsuario(@RequestBody Usuario usuario) {
		if(servicio.registrarUsuario(usuario)) {
			return new ResponseEntity<String>("El usuario ha sido creado satisfactoriamente papus :)",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Error interno al guardar el usuario.",HttpStatus.CONFLICT);
	}
	
	@Operation(summary="Este endpoint nos permite recuperar todos los usuarios registrados en nuestra Base de datos.")
	@GetMapping(value="usuarios")
	public ResponseEntity<List<Usuario>>  getAllUsers() {
		List<Usuario> list = servicio.ListarTodosUsuarios();
		//1.Agregar al header nuevos datos
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("test", "hola");
		System.out.println(list);
		//2. armamos la respuesta de tipo ResponseEntity
		return new ResponseEntity<List<Usuario>>(list, headers,HttpStatus.ACCEPTED);
	}
	@Operation(summary="Este endpoint nos permite recuperar un usuario por su ID")
	@GetMapping(value="Usuario-id")
	public ResponseEntity<?> usuarioById(@RequestParam String id){
		Usuario userFind = servicio.buscarUsuarioPorId(id);
		return new ResponseEntity<Usuario>(userFind,HttpStatus.OK);
	}
	
}
