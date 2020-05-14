package com.ruleta.redis.service;

import java.util.Map;

import com.ruleta.entities.Apuesta;
import com.ruleta.entities.Ruleta;


public interface RuletaService {
	
    Map<String, Ruleta> obtenerRuletas();
    Ruleta obtenerRuletaPorId(String id);
    String crearRuleta(Ruleta ruleta);
    void eliminarRuleta(String id);
    void actualizarRuleta(Ruleta ruleta, String id);
    void agregarApuestaARuleta(Ruleta ruleta, Apuesta apuesta);
	String abrirRuleta(String id);
	Map<String, String> obtenerRuletasConEstado();
	
}
