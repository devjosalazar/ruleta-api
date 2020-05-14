package com.ruleta.redis.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ruleta.entities.Apuesta;
import com.ruleta.entities.EstadoRuleta;
import com.ruleta.entities.Ruleta;

@Service
public class ApuestaServiceImpl implements ApuestaService{

	@Autowired
	private RedisTemplate<String, Apuesta> apuestaRedisTemplate;
	
	@Autowired
	private RuletaServiceImpl ruletaService;

	private static final String KEY_APUESTA = "Apuesta";
	
	private Ruleta ruleta = null;

	private HashOperations<String, String, Apuesta> operations;

	public ApuestaServiceImpl() {
	}

	@PostConstruct
	private void ini() {
		operations = apuestaRedisTemplate.opsForHash();
	}


	@Override
	public Map<String, Apuesta> obtenerApuestas() {
		return getOperations().entries(KEY_APUESTA);
	}

	
	@Override
	public Apuesta obtenerApuestaPorId(String id) {
		return (Apuesta) getOperations().get(KEY_APUESTA, id);
	}

	
	@Override
	public String crearApuesta(Apuesta apuesta) {
		apuesta.setId( UUID.randomUUID().toString());
		getOperations().put(KEY_APUESTA, apuesta.getId(), apuesta);
		return apuesta.getId();
	}

	
	@Override
	public void eliminarApuesta(String id) {
		getOperations().delete(KEY_APUESTA, id);
	}

	
	@Override
	public void actualizarApuesta(Apuesta apuesta, String id) {
		operations.put(KEY_APUESTA, apuesta.getId(), apuesta);
	}
	
	
	@Override
	public List<Apuesta> cerrarApuestas(String idRuleta) {
		
		ruleta = ruletaService.obtenerRuletaPorId(idRuleta);
		
		if(ruleta == null)
			return null;
		
		if(ruleta.getEstado().equalsIgnoreCase(EstadoRuleta.ABIERTO)){
			
	    	ruleta.setEstado(EstadoRuleta.CERRADO);
	    	ruletaService.actualizarRuleta(ruleta, idRuleta);
			return ruleta.getApuestas();
		}
		else {
			return null;
		}
	}
	

	@Override
	public String realizarApuesta(Apuesta apuesta) {
		
		ruleta = ruletaService.obtenerRuletaPorId(apuesta.getIdRuleta());
		
		if(ruleta == null)
			return "No existe la ruleta con id: "+apuesta.getIdRuleta();

		if(ruleta.getEstado().equalsIgnoreCase(EstadoRuleta.ABIERTO)){
			
			if(apuesta.getNumeroApuesta() < 0 || apuesta.getNumeroApuesta() > 36)
				return "Número de apuesta no valido";
			
			if(apuesta.getValorApuesta() < 0 || apuesta.getValorApuesta() > 10000.0)
				return "Valor de apuesta no permitido";
			
			this.crearApuesta(apuesta);
			ruletaService.agregarApuestaARuleta(ruleta, apuesta);
			ruletaService.actualizarRuleta(ruleta, ruleta.getId());

			return "Apuesta realizada con éxito";
		}
		else {
			return "La ruleta con id: "+apuesta.getIdRuleta()+" no esta abierta";
		}
	}


	public HashOperations<String, String, Apuesta> getOperations() {
		return operations;
	}
	
}
