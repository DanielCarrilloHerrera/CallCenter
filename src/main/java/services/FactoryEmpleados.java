package services;

import java.util.List;

import model.Empleado;
import util.TipoEmpleado;

/**
 * Clase abstracta encargada de especificar la estructura de una fábrica de empleados (Patrón de diseño Factory). 
 *
 * @see java.lang.Object
 * @author Daniel Jose Carrillo Herrera
 */
public abstract class FactoryEmpleados {

	/**
	 * Metodo para crear empleados del tipo especificado.
	 * @param tipoEmpleado es un valor de la enumeración TipoEmpleado.
	 * @param cantidad es un valor que define la cantidad de empleados a crear.
	 * @see util.TipoEmpleado
	 * @return una lista con los empleados creados.
	 */
	public abstract List<Empleado> crearEmpleados(TipoEmpleado tipoEmpleado, int cantidad);
	
}