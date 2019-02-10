package services;

import java.util.List;

import model.Empleado;
import util.TipoEmpleado;

public abstract class FactoryEmpleados {

	public abstract List<Empleado> crearEmpleados(TipoEmpleado tipoEmpleado, int cantidad);
	
}