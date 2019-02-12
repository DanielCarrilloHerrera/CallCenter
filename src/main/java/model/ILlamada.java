package model;

import java.time.Instant;

/**
 * Interfaz encargada de definir la estructura generica de las llamadas.
 *
 * @see java.lang.Object
 * @author Daniel Jose Carrillo Herrera
 */
public interface ILlamada {

	/**
	 * Metodo para establecer la duraci�n de la llamada.
	 * @param segundos es un valor int para especificar la duraci�n en segundos.
	 */
	public void setDuracionLlamada(int segundos);
	/**
	 * Metodo para obtener el valor en segundos de la duraci�n de la llamada.
	 * @return un int con la duraci�n de la llamada en segundos.
	 */
	public int getDuracionLlamada();
	/**
	 * Metodo para establecer la fecha de creaci�n de la llamada.
	 * @param timeLlamada es un valor Instant para especificar la fecha de creaci�n de la llamada.
	 * @see java.time.Instant
	 */
	public void setTimeLlamada(Instant timeLlamada);
	/**
	 * Metodo para obtener la fecha de creaci�n de la llamada.
	 * @return un Instant con la fecha de creaci�n de la llamada.
	 * @see java.time.Instant
	 */
	public Instant getTimeLlamada();
	/**
	 * Metodo para obtener el id �nico de cada llamada.
	 * @return un String con el id �nico de cada llamada.
	 */
	public String getUniqueId();
}
