package model;

import java.time.Instant;

import util.TipoEmpleado;

public abstract class Empleado {
	
	private final TipoEmpleado tipoEmpleado;
	private boolean ocupado;
	private ILlamada llamadaAsignada;
	
	public Empleado(TipoEmpleado tipoEmpleado) {
		super();
		this.tipoEmpleado = tipoEmpleado;
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

		
	
}
	
	
