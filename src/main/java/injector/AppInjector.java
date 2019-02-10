package injector;

import com.google.inject.AbstractModule;

import model.ILlamada;
import model.impl.LlamadaDuracionAleatoria;
import services.FactoryEmpleados;
import services.IDistpacher;
import services.impl.DistpacherImpl;
import services.impl.FactoryEmpleadosImpl;
import util.GeneradorDuracionAleatorio;
import util.GeneradorDuracionCincoADiez;

public class AppInjector extends AbstractModule{

	@Override
	protected void configure() {
		bind(IDistpacher.class).to(DistpacherImpl.class);
		bind(ILlamada.class).to(LlamadaDuracionAleatoria.class);
		bind(FactoryEmpleados.class).to(FactoryEmpleadosImpl.class);
		bind(GeneradorDuracionAleatorio.class).to(GeneradorDuracionCincoADiez.class);
	}
	

}
