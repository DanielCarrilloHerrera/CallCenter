package model.impl;

import model.Empleado;
import util.TipoEmpleado;

/**
 * Clase encargada de definir un empleado de tipo operador.
 *
 * @see model.Empleado
 * @see util.TipoEmpleado
 * @author Daniel Jose Carrillo Herrera
 */
public class Operador extends Empleado {

	/**
	 * Constructor encargado de definir al empleado como de tipo TipoEmpleado.OPERADOR
	 */
	public Operador() {
		super(TipoEmpleado.OPERADOR);
		// TODO Auto-generated constructor stub
	}

}
