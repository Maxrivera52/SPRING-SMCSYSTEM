package com.idat.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Models.Usuario;
import com.idat.Services.SUsuario;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 120)
public class CUsuario {
	@Autowired
	SUsuario servicio;
	
	@GetMapping("/listar")
	public List<Usuario> listarusuario(){
		return servicio.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Usuario> findById(@PathVariable int id){
		return servicio.findById(id);
	}
	
	@GetMapping("/login")
	@ResponseBody
	public Usuario loginUser(@RequestParam(name = "correo") String correo,@RequestParam String clave){
	//public Usuario loginUser(@RequestBody Object t){
		return servicio.loginUser(correo, clave);
	}
	
	/**
	@GetMapping(value = "/listar/{idUsuario}")
	public Optional<Usuario> buscarUsuario(@PathVariable int idUsuario){
		return servicio.buscarUsuario(idUsuario);
	}
*/
	@PostMapping("/save")
	public Usuario guardarUsuario(@RequestBody Usuario t) {
		 return servicio.save(t);
	}
	
	@PutMapping("/update")
	public void modificarUsuario(@RequestBody Usuario t) {
		servicio.save(t);
		//		servicio.guardarUsuario(t);
	}
/*
	//HABILITAR Y DESHABILITAR USUARIO
	@GetMapping("/habUsu/{IDusuario}")
	public void 
		HabilitarUsuario(@PathVariable("IDusuario") int IDusuario) {
		
		
		servicio.HabilitarUsuario(IDusuario);
	}
	
	
	//http://localhost:8070/Usuario/login/matrui@gmail.com&ferds87
	@GetMapping("/login/{usuario}&{pass}")
	public List<Map<String, Object>> 
		LoginUsuario(@PathVariable("usuario") String usuario,@PathVariable("pass") String pass) {
		
		return servicio.loginUsuario(usuario, pass);
	}
	
	
	//SI EL LOGIN ES CORRECTO DEVOLVERA 1, SI NO, SERA 0
	@GetMapping("/valLog/{usuario}&{pass}")
	public String 
		ValidarUsuario(@PathVariable("usuario") String usuario,@PathVariable("pass") String pass) {
		
		System.out.print(servicio.validarLogin(usuario, pass));
		
		return servicio.validarLogin(usuario, pass);
	}
	*/

}


