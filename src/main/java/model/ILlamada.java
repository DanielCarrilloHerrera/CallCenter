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
	 * Metodo para establecer la duración de la llamada.
	 * @param segundos es un valor int para especificar la duración en segundos.
	 */
	public void setDuracionLlamada(int segundos);
	/**
	 * Metodo para obtener el valor en segundos de la duración de la llamada.
	 * @return un int con la duración de la llamada en segundos.
	 */
	public int getDuracionLlamada();
	/**
	 * Metodo para establecer la fecha de creación de la llamada.
	 * @param timeLlamada es un valor Instant para especificar la fecha de creación de la llamada.
	 * @see java.time.Instant
	 */
	public void setTimeLlamada(Instant timeLlamada);
	/**
	 * Metodo para obtener la fecha de creación de la llamada.
	 * @return un Instant con la fecha de creación de la llamada.
	 * @see java.time.Instant
	 */
	public Instant getTimeLlamada();
	/**
	 * Metodo para obtener el id único de cada llamada.
	 * @return un String con el id único de cada llamada.
	 */
	public String getUniqueId();
}
