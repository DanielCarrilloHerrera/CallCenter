package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CallCenterLogger {
	
	private static Logger instancia;
	
	public synchronized static Logger getLogger(){
		if(instancia == null)
			instancia = LogManager.getLogger("log4jlogger");
		return instancia;
	}
}
