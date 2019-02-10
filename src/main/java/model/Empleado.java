package model;

import java.time.Instant;

import org.apache.commons.lang3.RandomStringUtils;

import util.TipoEmpleado;

public abstract class Empleado {
	
	private final TipoEmpleado tipoEmpleado;
	private boolean ocupado;
	private ILlamada llamadaAsignada;
	private String uniqueId;
	
	public Empleado(TipoEmpleado tipoEmpleado) {
		super();
		this.tipoEmpleado = tipoEmpleado;
		this.uniqueId = RandomStringUtils.random(10, true, true);
		this.ocupado = false;
	}

	
	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}


	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}


	public ILlamada getLlamadaAsignada() {
		return llamadaAsignada;
	}


	public void setLlamadaAsignada(ILlamada llamadaAsignada) {
		this.llamadaAsignada = llamadaAsignada;
		this.llamadaAsignada.setTimeLlamada(Instant.now());;
	}
	
	public String getUniqueId() {
		return this.uniqueId;
	}
		
}
	
	
