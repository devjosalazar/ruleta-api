package com.ruleta.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruleta.entities.Apuesta;
import com.ruleta.redis.service.ApuestaServiceImpl;

@RestController
@RequestMapping("/api")
public class ApuestaRestController {

	@Autowired
	private ApuestaServiceImpl apuestaService;
	
	
    @PutMapping("/apuesta/close/{idRuleta}")
	public ResponseEntity<List<Apuesta>> cerrarApuestas(@PathVariable String idRuleta) {
    	
    	List<Apuesta> listaApuestas = apuestaService.cerrarApuestas(idRuleta);
    	
    	if(listaApuestas != null){
    		return ResponseEntity.ok(listaApuestas);
    	}else {
    		return ResponseEntity.noContent().build();
    	}
	}
	
    @PostMapping(value = "/apuesta", consumes = "application/json", produces = "application/json")
    public String realizarApuesta(@RequestBody Apuesta apuesta) {
    	return apuestaService.realizarApuesta(apuesta);
	}
	
}
