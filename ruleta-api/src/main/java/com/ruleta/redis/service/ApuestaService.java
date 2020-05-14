package com.ruleta.redis.service;

import java.util.List;
import java.util.Map;

import com.ruleta.entities.Apuesta;


public interface ApuestaService {
	
    Map<String, Apuesta> obtenerApuestas();
    Apuesta obtenerApuestaPorId(String id);
    String crearApuesta(Apuesta apuesta);
    void eliminarApuesta(String id);
	void actualizarApuesta(Apuesta ruleta, String id);
	List<Apuesta> cerrarApuestas(String idRuleta);
	String realizarApuesta(Apuesta apuesta);
}
