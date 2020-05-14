package com.ruleta.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ruleta implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String estado;
	private List<Apuesta> apuestas = new ArrayList<>();
	
	
	public Ruleta() {
		
	}

	
	//Getterrs y setters

	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}
	

	public String getEstado() {
		return estado;
	}
	

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public List<Apuesta> getApuestas() {
		return apuestas;
	}


	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}


	@Override
    public String toString() {
        return "Ruleta [id=" + id + ", estado=" + estado + "]";
    }
	
}
