package model.impl;

import model.Empleado;
import util.TipoEmpleado;

/**
 * Clase encargada de definir un empleado de tipo director.
 *
 * @see model.Empleado
 * @see util.TipoEmpleado
 * @author Daniel Jose Carrillo Herrera
 */
public class Director extends Empleado {

	/**
	 * Constructor encargado de definir al empleado como de tipo TipoEmpleado.DIRECTOR
	 */
	public Director() {
		super(TipoEmpleado.DIRECTOR);
	}

}
