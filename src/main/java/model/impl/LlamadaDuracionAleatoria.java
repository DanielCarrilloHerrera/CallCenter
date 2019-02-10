package model.impl;

import java.time.Instant;

import org.apache.commons.lang3.RandomStringUtils;

import model.ILlamada;

public class LlamadaDuracionAleatoria implements ILlamada {

	private int duracion;
	private Instant timeLlamada;
	private String uniqueId;
	
	public LlamadaDuracionAleatoria(){
		this.duracion = 0;
		this.uniqueId = RandomStringUtils.random(10, true, true);
	}
	
	public void setDuracionLlamada(int segundos) {
		this.duracion = segundos;
	}

	public int getDuracionLlamada() {
		return this.duracion;
	}

	@Override
	public Instant getTimeLlamada() {
		return this.timeLlamada;
	}

	@Override
	public void setTimeLlamada(Instant timeLlamada) {
		this.timeLlamada = timeLlamada;
		
	}

	@Override
	public String getUniqueId() {
		return this.uniqueId;
	}

}
