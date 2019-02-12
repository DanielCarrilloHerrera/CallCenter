package services;


import model.ILlamada;
import util.TipoEmpleado;

/**
 * Esta es una interfaz que debe ser implementada para poder crear dispachers
 *
 * @see java.lang.Object
 * @author Daniel Jose Carrillo Herrera
 */

public interface IDistpacher {
	
	/**
	 * Metodo distpatchCall. Para asignar la llamada a un empleado no ocupado
	 * @param llamada es una implementaci�n de la interfaz ILlamada
	 * @param numeroIntento es un valor que determina el numero de intento de asignaci�n de la llamada. M�ximo 3.
	 * @return un boolean confirmando si la llamada se asigno a un empleado o no. 
	 */
	boolean dispatchCall(ILlamada llamada, int numeroIntento);
	/**
	 * Metodo contratarEmpleado. Para asignar la llamada a un empleado no ocupado
	 * @param tipoEmpleado es un valor de la enumeraci�n TipoEmpleado. Puede ser OPERADOR, SUPERVISOR o DIRECTOR
	 * @param cantidad determina la cantidad de empleados de tipo especificado a crear.
	 */
	void contratarEmpleados(TipoEmpleado tipoEmpleado, int cantidad);
	/**
	 * Metodo revisarEmpleadosDesocupados. Para revisar que empleados no estan atendiendo una llamada
	 */
	void revisarEmpleadosDesocupados();
	/**
	 * Metodo despedirATodosLosEmpleados. Para limpiar la coleccion de empleados existentes
	 */
	void despedirATodosLosEmpleados();
}
