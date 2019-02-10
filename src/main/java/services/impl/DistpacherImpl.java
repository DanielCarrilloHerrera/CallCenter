package services.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import model.Empleado;
import model.ILlamada;
import model.impl.Director;
import model.impl.Operador;
import model.impl.Supervisor;
import services.IDistpacher;
import util.TipoEmpleado;

@Singleton
public class DistpacherImpl implements IDistpacher {

	private List<Empleado> empleados;

	public DistpacherImpl() {
		super();
		this.empleados = new ArrayList<Empleado>();
	}

	// --
	//@Inject
	public synchronized boolean dispatchCall(ILlamada llamada, int numeroIntento) {

		Optional<Empleado> operarioAOcupar = empleados.stream()
				.filter(empleado -> ((empleado.getTipoEmpleado() == TipoEmpleado.OPERADOR) && (!empleado.isOcupado())))
				.findFirst();

		if (operarioAOcupar.isPresent()) {
			operarioAOcupar.get().setOcupado(true);
			operarioAOcupar.get().setLlamadaAsignada(llamada);
			System.out.println("Operario asignado.");
			return true;
		}

		Optional<Empleado> supervisorAOcupar = empleados.stream().filter(
				empleado -> ((empleado.getTipoEmpleado() == TipoEmpleado.SUPERVISOR) && (!empleado.isOcupado())))
				.findFirst();

		if (supervisorAOcupar.isPresent()) {
			supervisorAOcupar.get().setOcupado(true);
			supervisorAOcupar.get().setLlamadaAsignada(llamada);
			System.out.println("Supervisor asignado.");
			return true;
		}

		Optional<Empleado> directorAOcupar = empleados.stream()
				.filter(empleado -> ((empleado.getTipoEmpleado() == TipoEmpleado.DIRECTOR) && (!empleado.isOcupado())))
				.findFirst();

		if (directorAOcupar.isPresent()) {
			directorAOcupar.get().setOcupado(true);
			directorAOcupar.get().setLlamadaAsignada(llamada);
			System.out.println("Director asignado.");
			return true;
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Reintentando asignación a empleado no ocupado...");
		if(numeroIntento < 3){
			revisarEmpleadosDesocupados();
			return this.dispatchCall(llamada, ++numeroIntento);
		}else{
			System.out.println("No se pudo asignar la llamada a un empleado. Intente de nuevo.");
			return true;
		}
		
	}

	// --
	@Override
	public void revisarEmpleadosDesocupados() {
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
	public void agregarEmpleados(TipoEmpleado tipoEmpleado, int cantidad) {
		int contador = 0;
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
		}

	}

}
