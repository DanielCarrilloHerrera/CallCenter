package services;

import model.ILlamada;
import util.TipoEmpleado;

public interface IDistpacher {
	
	boolean dispatchCall(ILlamada llamada, int numeroIntento);
	void agregarEmpleados(TipoEmpleado tipoEmpleado, int cantidad);
	void revisarEmpleadosDesocupados();
}
