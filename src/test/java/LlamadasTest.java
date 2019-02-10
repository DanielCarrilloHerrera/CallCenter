import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
		injector = Guice.createInjector(new AppInjector());;
		generadorAleatorio = injector.getInstance(GeneradorDuracionAleatorio.class);
		distpacher = injector.getInstance(IDistpacher.class);
	}

	@BeforeMethod
	public void cleanDistpacher(){
		distpacher.despedirATodosLosEmpleados();
		distpacher.contratarEmpleados(TipoEmpleado.OPERADOR, 4);
		distpacher.contratarEmpleados(TipoEmpleado.SUPERVISOR, 4);
		distpacher.contratarEmpleados(TipoEmpleado.DIRECTOR, 2);
	}
	
	//--
	@Test(threadPoolSize = 10, invocationCount = 10, priority = 1)
	public void pruebaUnoDebeComprobarQueElDistpacherPuedeManejarDiezLlamadas(){
		ILlamada llamada = injector.getInstance(ILlamada.class);
		llamada.setDuracionLlamada(generadorAleatorio.getDuracionAleatoria());
		Assert.assertTrue(distpacher.dispatchCall(llamada, 0));
	}
	
	//--
	@Test(threadPoolSize = 30, invocationCount = 30, priority = 2)
	public void pruebaDosComprobarQueElDistpacherPuedeManejarMasDeDiezLlamadas(){
		ILlamada llamada = injector.getInstance(ILlamada.class);
		llamada.setDuracionLlamada(generadorAleatorio.getDuracionAleatoria());
		Assert.assertTrue(distpacher.dispatchCall(llamada, 0));
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		injector = null;
	}
}
