package services.impl;

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

	@Inject
	public synchronized boolean dispatchCall(ILlamada llamada) {
				
		Optional<Empleado> operarioAOcupar = 
				empleados.stream().filter(empleado -> 
									((empleado.getTipoEmpleado() == TipoEmpleado.OPERADOR) && (!empleado.isOcupado()))).findFirst();
				
				
		if(operarioAOcupar.isPresent()){
			operarioAOcupar.get().setOcupado(true);
			System.out.println("Operario asignado");
			return true;
		} 
		
		Optional<Empleado> supervisorAOcupar = 
				empleados.stream().filter(empleado -> 
									((empleado.getTipoEmpleado() == TipoEmpleado.SUPERVISOR) && (!empleado.isOcupado()))).findFirst();
				
				
		if(supervisorAOcupar.isPresent()){
			supervisorAOcupar.get().setOcupado(true);
			System.out.println("Supervisor asignado");
			return true;
		}
		
		Optional<Empleado> directorAOcupar = 
				empleados.stream().filter(empleado -> 
									((empleado.getTipoEmpleado() == TipoEmpleado.DIRECTOR) && (!empleado.isOcupado()))).findFirst();
				
				
		if(directorAOcupar.isPresent()){
			directorAOcupar.get().setOcupado(true);
			System.out.println("Director asignado");
			return true;
		}
				
		return false;
	}

	public void agregarEmpleados(TipoEmpleado tipoEmpleado, int cantidad) {
		int contador = 0;
		switch(tipoEmpleado){
			
			case OPERADOR:
				while(contador < cantidad){
					this.empleados.add(new Operador());
					contador++;
				}
			break;
			
			case SUPERVISOR:
				while(contador < cantidad){
					this.empleados.add(new Supervisor());
					contador++;
				}
			break;
			
			case DIRECTOR:
				while(contador < cantidad){
					this.empleados.add(new Director());
					contador++;
				}
			break;
		}
		
	}


	
}
