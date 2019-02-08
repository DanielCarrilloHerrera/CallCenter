package services;

import model.ILlamada;
import util.TipoEmpleado;

public interface IDistpacher {
	
	boolean dispatchCall(ILlamada llamada);
	void agregarEmpleados(TipoEmpleado tipoEmpleado, int cantidad);
}
