package com.ruleta.apirest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruleta.entities.Apuesta;
import com.ruleta.entities.Ruleta;
import com.ruleta.redis.service.ApuestaServiceImpl;
import com.ruleta.redis.service.RuletaServiceImpl;

@RestController
@RequestMapping("/api")
public class RuletaRestController {

	@Autowired
	private RuletaServiceImpl ruletaService;
	
	private String estadoDeOperacion;
	
	
    @PostMapping(value = "/ruleta", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> crearRuleta(@RequestBody Ruleta ruleta) {
    	ruletaService.crearRuleta(ruleta);
    	return new ResponseEntity<>(ruleta.getId(),HttpStatus.CREATED);
	}
    

    @PutMapping("/ruleta/open/{id}")
	public ResponseEntity<String> abrirRuleta(@PathVariable String id) {
    	estadoDeOperacion = ruletaService.abrirRuleta(id);
    	return new ResponseEntity<>(estadoDeOperacion,HttpStatus.CREATED);
	}
    
    
	@GetMapping("/ruletas/status")
	public Map<String, String> obtenerRuletasConEstado() {
		Map<String, String> rueltasStatus= ruletaService.obtenerRuletasConEstado();
		return rueltasStatus;
	}
    
	
	@GetMapping("/ruletas")
	public Map<String, Ruleta> obtenerRuletas() {
		return ruletaService.obtenerRuletas();
	}
	
	
	@GetMapping("/ruletas/{id}")
	public Ruleta obtenerRuletaPorId(@PathVariable String id) {
		return ruletaService.obtenerRuletaPorId(id);
	}
	
    
	@DeleteMapping("/ruletas/{id}")
	public void eliminarRuleta(@PathVariable String id)
	{
		ruletaService.eliminarRuleta(id);
	}
	
}
