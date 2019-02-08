package model;

import util.TipoEmpleado;

public abstract class Empleado {
	
	private final TipoEmpleado tipoEmpleado;
	private boolean ocupado;
	
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
		
}
	
	
