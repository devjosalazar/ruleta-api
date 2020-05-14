package com.ruleta.entities;

import java.io.Serializable;

public class Apuesta implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String 	id;
	private String 	idRuleta;
	private int 	numeroApuesta;
	private String 	colorApuesta;
	private Double 	valorApuesta;
	
	
	public Apuesta() {
		
	}

	
	//Getterrs y setters
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getIdRuleta() {
		return idRuleta;
	}


	public void setIdRuleta(String idRuleta) {
		this.idRuleta = idRuleta;
	}


	public int getNumeroApuesta() {
		return numeroApuesta;
	}


	public void setNumeroApuesta(int numeroApuesta) {
		this.numeroApuesta = numeroApuesta;
	}


	public String getColorApuesta() {
		return colorApuesta;
	}


	public void setColorApuesta(String colorApuesta) {
		this.colorApuesta = colorApuesta;
	}


	public Double getValorApuesta() {
		return valorApuesta;
	}


	public void setValorApuesta(Double valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	
	@Override
	public String toString() {
		return  "Apuesta [id=" + id + ", idRuleta=" + idRuleta + ", numeroApuesta=" + numeroApuesta +
				", colorApuesta=" + colorApuesta + ", valorApuesta=" + valorApuesta +"]";
	}
	
}
