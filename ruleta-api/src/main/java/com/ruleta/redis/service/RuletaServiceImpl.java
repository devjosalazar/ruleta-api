package com.ruleta.redis.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.digester.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ruleta.entities.Apuesta;
import com.ruleta.entities.EstadoRuleta;
import com.ruleta.entities.Ruleta;

@Service
public class RuletaServiceImpl implements RuletaService{

	@Autowired
	private RedisTemplate<String, Ruleta> ruletaRedisTemplate;
	
	private static final String KEY_RULETA = "Ruleta";
   
	private HashOperations<String, String, Ruleta> operations;
	
	public RuletaServiceImpl() {
	}
	
	
	@PostConstruct
	private void ini() {
		operations = ruletaRedisTemplate.opsForHash();
	}
	
	
	@Override
	public Map<String, Ruleta> obtenerRuletas() {
		return getOperations().entries(KEY_RULETA);
	}

	
	@Override
	public Ruleta obtenerRuletaPorId(String id) {
		return (Ruleta) getOperations().get(KEY_RULETA, id);
	}

	
	@Override
	public String crearRuleta(Ruleta ruleta) {
		ruleta.setId( UUID.randomUUID().toString());
		ruleta.setEstado(EstadoRuleta.CREADO);
		getOperations().put(KEY_RULETA, ruleta.getId(), ruleta);
		return ruleta.getId();
	}

	
	@Override
	public void eliminarRuleta(String id) {
		getOperations().delete(KEY_RULETA, id);
	}

	
	@Override
	public void actualizarRuleta(Ruleta ruleta, String id) {
		operations.put(KEY_RULETA, ruleta.getId(), ruleta);
	}
	
	@Override
	public void agregarApuestaARuleta(Ruleta ruleta, Apuesta apuesta) {
		ruleta.getApuestas().add(apuesta);
	}

	
	@Override
	public Map<String, String> obtenerRuletasConEstado() {
		
		Map<String, String> rueltasConEsatdo = new HashMap<>();
		Map<String, Ruleta> ruletas = this.obtenerRuletas();
		
		for (Ruleta ruleta : ruletas.values()) { 
			rueltasConEsatdo.put(ruleta.getId(), ruleta.getEstado());
		}

		return rueltasConEsatdo;
	}
	
	
	@Override
	public String abrirRuleta(String id) {
		
		Ruleta ruleta = this.obtenerRuletaPorId(id);
		
		if(ruleta == null)
			return "no existe";
		
		if(ruleta.getEstado().equalsIgnoreCase(EstadoRuleta.CREADO)){
			ruleta.setEstado(EstadoRuleta.ABIERTO);
			this.actualizarRuleta(ruleta, id);
			return "exitosa";
		}
		else {
			return "denegada";
		}
	}
	
	
	public HashOperations<String, String, Ruleta> getOperations() {
		return operations;
	}
	
}
