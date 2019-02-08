package model.impl;

import model.ILlamada;

public class LlamadaDuracionAleatoria implements ILlamada {

	private int duracion;
	
	public void setDuracionLlamada(int segundos) {
		this.duracion = segundos;
	}

	public int getDuracionLlamada() {
		return duracion;
	}

}
