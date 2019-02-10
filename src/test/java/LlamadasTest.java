import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.inject.Guice;
import com.google.inject.Injector;
import injector.AppInjector;
import model.ILlamada;
import services.IDistpacher;
import util.GeneradorDuracionAleatorio;
import util.TipoEmpleado;

public class LlamadasTest {

	private Injector injector;
	private IDistpacher distpacher;
	private GeneradorDuracionAleatorio generadorAleatorio;
	
	@BeforeClass
	public void setUp() throws Exception{
		injector = Guice.createInjector(new AppInjector());
		distpacher = injector.getInstance(IDistpacher.class);
		generadorAleatorio = injector.getInstance(GeneradorDuracionAleatorio.class);
		distpacher.agregarEmpleados(TipoEmpleado.OPERADOR, 3);
		distpacher.agregarEmpleados(TipoEmpleado.SUPERVISOR, 2);
		distpacher.agregarEmpleados(TipoEmpleado.DIRECTOR, 2);
	}
	

	@Test(threadPoolSize = 15, invocationCount = 15,  timeOut = 30000)
	public void debeComprobarQueElDistpacherPuedeManejarTodasLasLlamadasEntrantes(){
		//System.out.print("Ejecutando llamada a las " + LocalTime.now() + "\n" );
		ILlamada llamada = injector.getInstance(ILlamada.class);
		llamada.setDuracionLlamada(generadorAleatorio.getDuracionAleatoria());
		Assert.assertTrue(distpacher.dispatchCall(llamada, 0));
	}
	
	
	@AfterClass
	public void tearDown() throws Exception {
		injector = null;
	}
}
