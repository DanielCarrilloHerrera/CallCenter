package services.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import model.Empleado;
import model.ILlamada;
import services.FactoryEmpleados;
import services.IDistpacher;
import util.CallCenterLogger;
import util.TipoEmpleado;

/**
 * Esta es una clase que implementa la interfaz IDistpacher para crear dispachers
 *
 * @see services.IDistpacher
 * @author Daniel Jose Carrillo Herrera
 */
@Singleton
public class DistpacherImpl implements IDistpacher {

	private List<Empleado> empleados;
	
	@Inject
	private FactoryEmpleados factoryEmpleados;

	/**
	 * Constructor encargado de definir la implementación de la interfaz IDistpacher
	 */
	public DistpacherImpl() {
		super();
		this.empleados = new ArrayList<Empleado>();
	}

	/**
	 * Metodo distpatchCall. Para asignar la llamada a un empleado no ocupado
	 * @param llamada es una implementación de la interfaz ILlamada
	 * @param numeroIntento es un valor que determina el numero de intento de asignación de la llamada. Máximo 3.
	 * @return un boolean confirmando si la llamada se asigno a un empleado o no. 
	 */
	public synchronized boolean dispatchCall(ILlamada llamada, int numeroIntento) {

		Supplier<Stream<Empleado>> streamEmpleados = () -> empleados.stream();
		
		Empleado empleadoAOcupar = 
				streamEmpleados.get()
					.filter(empleado -> ((empleado.getTipoEmpleado() == TipoEmpleado.OPERADOR) && (!empleado.isOcupado()))).findFirst()
					.orElse(streamEmpleados.get()
						.filter(empleado -> ((empleado.getTipoEmpleado() == TipoEmpleado.SUPERVISOR) && (!empleado.isOcupado()))).findFirst()
					.orElse(streamEmpleados.get()
						.filter(empleado -> ((empleado.getTipoEmpleado() == TipoEmpleado.DIRECTOR) && (!empleado.isOcupado()))).findFirst().orElse(null)));

		if (empleadoAOcupar != null) {
			empleadoAOcupar.setOcupado(true);
			empleadoAOcupar.setLlamadaAsignada(llamada);
			CallCenterLogger.getLogger().info("Llamada #" + llamada.getUniqueId() + " asignada al "+ empleadoAOcupar.getTipoEmpleado().toString() +" con id #" + empleadoAOcupar.getUniqueId());
			return true;
		}


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			CallCenterLogger.getLogger().error(e.getMessage());
		}
		CallCenterLogger.getLogger().info("Reintentando asignación de llamada #"+llamada.getUniqueId() +" a empleado no ocupado...");
		if(numeroIntento < 3){
			revisarEmpleadosDesocupados();
			return this.dispatchCall(llamada, ++numeroIntento);
		}else{
			CallCenterLogger.getLogger().info("No se pudo asignar la llamada #"+ llamada.getUniqueId() + " a un empleado. Reintentar mas tarde.");
			return true;
		}
		
	}

	/**
	 * Metodo revisarEmpleadosDesocupados. Para revisar que empleados no estan atendiendo una llamada
	 */
	@Override
	public synchronized void revisarEmpleadosDesocupados() {
		this.empleados.forEach(empleado -> {
			if (empleado.isOcupado()) {
				long timeCreacionLlamadaEnSegundos = empleado.getLlamadaAsignada().getTimeLlamada().getEpochSecond();
				long timeActualEnSegundos = Instant.now().getEpochSecond();
				long duracionLlamadaEnSegundos = Long.valueOf(empleado.getLlamadaAsignada().getDuracionLlamada());

				if (timeActualEnSegundos > timeCreacionLlamadaEnSegundos + duracionLlamadaEnSegundos) {
					empleado.setOcupado(false);
				}
			}
		});

	}

	/**
	 * Metodo contratarEmpleado. Para asignar la llamada a un empleado no ocupado
	 * @param tipoEmpleado es un valor de la enumeración TipoEmpleado. Puede ser OPERADOR, SUPERVISOR o DIRECTOR
	 * @param cantidad determina la cantidad de empleados de tipo especificado a crear.
	 */
	public void contratarEmpleados(TipoEmpleado tipoEmpleado, int cantidad) {
		this.empleados.addAll(factoryEmpleados.crearEmpleados(tipoEmpleado, cantidad));
	}

	/**
	 * Metodo despedirATodosLosEmpleados. Para limpiar la coleccion de empleados existentes
	 */
	@Override
	public void despedirATodosLosEmpleados() {
		this.empleados.clear();
	}

}
