package injector;

import com.google.inject.AbstractModule;

import model.ILlamada;
import model.impl.LlamadaDuracionAleatoria;
import services.FactoryEmpleados;
import services.IDistpacher;
import services.impl.DistpacherImpl;
import services.impl.FactoryEmpleadosImpl;
import util.GeneradorDuracionAleatorio;
import util.impl.GeneradorDuracionCincoADiez;
/**
 * Esta es una clase encargada de ligar especificaciones a sus respectivas implementaciones, de acuerdo al esquema de Google Guice.
 *
 * @see java.lang.Object
 * @author Daniel Jose Carrillo Herrera
 */
public class AppInjector extends AbstractModule{

	/**
	* Metodo encargado de lugar especificaciones a sus respectivas implementaciones. 
	*/
	@Override
	protected void configure() {
		bind(IDistpacher.class).to(DistpacherImpl.class);
		bind(ILlamada.class).to(LlamadaDuracionAleatoria.class);
		bind(FactoryEmpleados.class).to(FactoryEmpleadosImpl.class);
		bind(GeneradorDuracionAleatorio.class).to(GeneradorDuracionCincoADiez.class);
	}
	

}
