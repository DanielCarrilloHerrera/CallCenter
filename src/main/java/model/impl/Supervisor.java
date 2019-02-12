package model.impl;

import model.Empleado;
import util.TipoEmpleado;

/**
 * Clase encargada de definir un empleado de tipo supervisor.
 *
 * @see model.Empleado
 * @see util.TipoEmpleado
 * @author Daniel Jose Carrillo Herrera
 */
public class Supervisor extends Empleado {

	/**
	 * Constructor encargado de definir al empleado como de tipo TipoEmpleado.SUPERVISOR
	 */
	public Supervisor() {
		super(TipoEmpleado.SUPERVISOR);
	}

}
