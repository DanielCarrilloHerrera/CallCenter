package model;

import java.time.Instant;
import org.apache.commons.lang3.RandomStringUtils;
import util.TipoEmpleado;

/**
 * Esta es una clase abstracta, encargada de definir la estructura generica de los empleados.
 *
 * @see java.lang.Object
 * @author Daniel Jose Carrillo Herrera
 */
public abstract class Empleado {
	
	private final TipoEmpleado tipoEmpleado;
	private boolean ocupado;
	private ILlamada llamadaAsignada;
	private String uniqueId;
	
	/**
	 * Constructor para definir el tipo de empleado.
	 * @param tipoEmpleado es un valor de la enumeración TipoEmpleado. Puede ser OPERARIO, SUPERVISOR o DIRECTOR.
	 * @see util.TipoEmpleado
	 */
	public Empleado(TipoEmpleado tipoEmpleado) {
		super();
		this.tipoEmpleado = tipoEmpleado;
		this.uniqueId = RandomStringUtils.random(10, true, true);
		this.ocupado = false;
	}

	/**
	 * Metodo para obtener el tipo de empleado.
	 * @return el tipo del empleado.
	 * @see util.TipoEmpleado
	 */
	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	/**
	 * Metodo para indicar si un empleado esta ocupado.
	 * @param ocupado es un valor boolean para especificar si el empleado esta ocupado o no.
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	/**
	 * Metodo para conocer si el empleado esta ocupado.
	 * @return el valor boolean que indica si el empleado esta ocupado o no.
	 */
	public boolean isOcupado() {
		return ocupado;
	}
	
	/**
	 * Metodo para obtener la implementación de la intefaz ILlamada.
	 * @return una implementación de la interfaz ILlamada.
	 * @see ILlamada
	 */
	public ILlamada getLlamadaAsignada() {
		return llamadaAsignada;
	}

	/**
	 * Metodo para asignar la llamada a un empleado.
	 * @param llamadaAsignada debe ser una implementación de la interfaz ILladama.
	 * @see ILlamada
	 */
	public void setLlamadaAsignada(ILlamada llamadaAsignada) {
		this.llamadaAsignada = llamadaAsignada;
		this.llamadaAsignada.setTimeLlamada(Instant.now());;
	}
	
	/**
	 * Metodo para obtener el id único autogenerado para cada empleado.
	 * @return un String con el id unico para cada empleado.
	 * @see java.lang.String
	 */
	public String getUniqueId() {
		return this.uniqueId;
	}
		
}
	
	
