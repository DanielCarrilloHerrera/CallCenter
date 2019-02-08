import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.inject.Guice;
import com.google.inject.Injector;
import injector.AppInjector;import model.Empleado;
import model.ILlamada;
import services.IDistpacher;
import java.time.LocalTime;
import util.GeneradorDuracionAleatorio;
import util.TipoEmpleado;

public class LlamadasTest {

	private Injector injector;
	private IDistpacher distpacher;
	private GeneradorDuracionAleatorio generadorAleatorio;
	
	@BeforeTest
	public void setUp() throws Exception{
		injector = Guice.createInjector(new AppInjector());
		distpacher = injector.getInstance(IDistpacher.class);
		generadorAleatorio = injector.getInstance(GeneradorDuracionAleatorio.class);
		distpacher.agregarEmpleados(TipoEmpleado.OPERADOR, 4);
		distpacher.agregarEmpleados(TipoEmpleado.SUPERVISOR, 3);
		distpacher.agregarEmpleados(TipoEmpleado.DIRECTOR, 3);
	}
	

	@Test(threadPoolSize = 10, invocationCount = 10,  timeOut = 15000)
	public void debeComprobarQueElDistpacherPuedeManejarDiezLlamadas(){
		//System.out.print("Ejecutando llamada a las " + LocalTime.now() + "\n" );
		ILlamada llamada = injector.getInstance(ILlamada.class);
		llamada.setDuracionLlamada(generadorAleatorio.getDuracionAleatoria());
		Assert.assertTrue(distpacher.dispatchCall(llamada));
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		injector = null;
	}
}
