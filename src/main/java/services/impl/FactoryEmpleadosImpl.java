package services.impl;

import java.util.ArrayList;
import java.util.List;

import model.Empleado;
import model.impl.Director;
import model.impl.Operador;
import model.impl.Supervisor;
import services.FactoryEmpleados;
import util.TipoEmpleado;

public class FactoryEmpleadosImpl extends FactoryEmpleados {

	@Override
	public List<Empleado> crearEmpleados(TipoEmpleado tipoEmpleado, int cantidad) {
		
		List<Empleado> retorno = new ArrayList<Empleado>();
		int contador = 0;
		switch (tipoEmpleado) {
		case OPERADOR:
			while(contador < cantidad){
				retorno.add(new Operador());
				contador++;
			}
		return retorno;	
		
		case SUPERVISOR:
			while(contador < cantidad){
				retorno.add(new Supervisor());
				contador++;
			}
		return retorno;

		case DIRECTOR:
			while(contador < cantidad){
				retorno.add(new Director());
				contador++;
			}
		return retorno;

		default:
			return null;
		}
	}

}
