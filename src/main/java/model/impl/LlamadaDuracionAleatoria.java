package model.impl;

import java.time.Instant;
import org.apache.commons.lang3.RandomStringUtils;
import model.ILlamada;

/**
 * Clase encargada de especificar una llamada de duración aleatoria. 
 *
 * @see model.ILlamada
 * @author Daniel Jose Carrillo Herrera
 */
public class LlamadaDuracionAleatoria implements ILlamada {

	private int duracion;
	private Instant timeLlamada;
	private String uniqueId;
	
	/**
	 * Constructor encargado de especificar una llamada de duración aleatoria. 
	 */
	public LlamadaDuracionAleatoria(){
		this.duracion = 0;
		this.uniqueId = RandomStringUtils.random(10, true, true);
	}
	
	/**
	 * Metodo para definir la duración de una llamada.
	 * @param segundos es un parametro de tipo int para definir la duración de la llamada en segundos.
	 */
	public void setDuracionLlamada(int segundos) {
		this.duracion = segundos;
	}

	/**
	 * Metodo para obtener la duración de una llamada.
	 * @return la duración de la llamada
	 */
	public int getDuracionLlamada() {
		return this.duracion;
	}

	/**
	 * Metodo para obtener la fecha de creación de una llamada.
	 * @return la fecha de creación de la llamada
	 * @see java.time.Instant;
	 */
	@Override
	public Instant getTimeLlamada() {
		return this.timeLlamada;
	}

	/**
	 * Metodo para definir la fecha de creación de una llamada.
	 * @param timeLlamada es un parametro de tipo Instant para definir la fecha de creación de llamada.
	 * @see java.time.Instant;
	 */
	@Override
	public void setTimeLlamada(Instant timeLlamada) {
		this.timeLlamada = timeLlamada;
	}

	/**
	 * Metodo para obtener el id único de cada llamada.
	 */
	@Override
	public String getUniqueId() {
		return this.uniqueId;
	}

}
