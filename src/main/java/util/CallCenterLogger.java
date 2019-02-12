package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase encargada de especificar el logger para la aplicaci�n. 
 *
 * @author Daniel Jose Carrillo Herrera
 */
public class CallCenterLogger {
	
	private static Logger instancia;
	
	/**
	 * Metodo para obtener el logger de la aplicaci�n.
	 * @see org.apache.logging.log4j.Logger;
	 * @return el logger de la aplicaci�n.
	 */
	public synchronized static Logger getLogger(){
		if(instancia == null)
			instancia = LogManager.getLogger("log4jlogger");
		return instancia;
	}
}
