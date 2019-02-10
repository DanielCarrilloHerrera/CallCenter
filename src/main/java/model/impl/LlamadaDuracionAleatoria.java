package model.impl;

import java.time.Instant;

import model.ILlamada;

public class LlamadaDuracionAleatoria implements ILlamada {

	private int duracion;
	private Instant timeLlamada;
	
	public LlamadaDuracionAleatoria(){
		this.duracion = 0;
	}
	
	public void setDuracionLlamada(int segundos) {
		this.duracion = segundos;
	}

	public int getDuracionLlamada() {
		return duracion;
	}

	@Override
	public Instant getTimeLlamada() {
		return timeLlamada;
	}

	@Override
	public void setTimeLlamada(Instant timeLlamada) {
		this.timeLlamada = timeLlamada;
		
	}

}
