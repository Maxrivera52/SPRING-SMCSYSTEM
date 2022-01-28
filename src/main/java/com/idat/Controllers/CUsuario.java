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

import com.idat.Interfaces.IUsuario;
import com.idat.Models.RecoveryAccount;
import com.idat.Models.Usuario;
import com.idat.Services.SUsuario;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class CUsuario {
	@Autowired
	SUsuario servicio;
	
	@Autowired
	CRecoveryAccount controllerRecovery;
	
	@Autowired
	IUsuario data;
	
	@CrossOrigin(origins = "http://localhost:4200")
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
		return servicio.loginUser(correo, clave);
	}
	
	@PostMapping("/save")
	public Usuario guardarUsuario(@RequestBody Usuario t) {
		 return servicio.save(t);
	}
	
	@PutMapping("/update")
	public void modificarUsuario(@RequestBody Usuario t) {
		servicio.save(t);
	}
	@GetMapping("/recoverUserWithCredentials")
	public String existEmail(@RequestParam(name = "keycode")String keycode,@RequestParam(name = "email") String email,
			@RequestParam(name = "password")String password){
		String verified = recoveryAccount(email, keycode);
		if(!verified.equals("verificated")) {
			return "unauthorized";
		}
		Usuario us = data.loginUserMailPass(email);
		us.setClave(password);
		us = guardarUsuario(us);
		if(us==null) {
			return "error";
		}
		RecoveryAccount recovery = controllerRecovery.getRecoveryCode(email);
		controllerRecovery.delete(recovery.getId());
		return "success";
	}
	
	
	@GetMapping("/sendRecoveryEmail")
	public String recoveryAccount(@RequestParam(name = "email") String email) {
		RecoveryAccount recovery = controllerRecovery.save(email);
		if(recovery==null) {
			return "nonregistered";
		}
		servicio.sendRecoveryPassword(email,recovery.getKeycode());
		return "sended";
	}
	

	@GetMapping("/verifyRecoveryCode")
	public String recoveryAccount(@RequestParam(name = "email") String email,@RequestParam(name = "keycode")String keycode) {
		RecoveryAccount recovery = controllerRecovery.getRecoveryCode(email);
		if(recovery==null) {
			return "nonregistered";
		}
		if(!recovery.getKeycode().equals(keycode)) {
			return "nonverificated";
		}		
		return "verificated";
	}
}


