package services.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import model.Empleado;
import model.ILlamada;
import model.impl.Director;
import model.impl.Operador;
import model.impl.Supervisor;
import services.FactoryEmpleados;
import services.IDistpacher;
import util.CallCenterLogger;
import util.TipoEmpleado;

@Singleton
public class DistpacherImpl implements IDistpacher {

	private List<Empleado> empleados;
	
	@Inject
	private FactoryEmpleados factoryEmpleados;

	public DistpacherImpl() {
		super();
		this.empleados = new ArrayList<Empleado>();
	}

	// --
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

	// --
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

	// --
	public void contratarEmpleados(TipoEmpleado tipoEmpleado, int cantidad) {
		this.empleados.addAll(factoryEmpleados.crearEmpleados(tipoEmpleado, cantidad));
		/*int contador = 0;
		switch (tipoEmpleado) {

		case OPERADOR:
			while (contador < cantidad) {
				this.empleados.add(new Operador());
				contador++;
			}
			break;

		case SUPERVISOR:
			while (contador < cantidad) {
				this.empleados.add(new Supervisor());
				contador++;
			}
			break;

		case DIRECTOR:
			while (contador < cantidad) {
				this.empleados.add(new Director());
				contador++;
			}
			break;
		}*/

	}

	//--
	@Override
	public void despedirATodosLosEmpleados() {
		this.empleados.clear();
	}

}
