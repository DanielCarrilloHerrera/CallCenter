package util.impl;

import util.GeneradorDuracionAleatorio;
 
/**
 * Esta es una clase que implementa la clase abstracta GeneradorDuraciónAleatorio. Genera números de duración desde cinco a diez.
 *
 * @see util.GeneradorDuracionAleatorio
 * @author Daniel Jose Carrillo Herrera
 */
public class GeneradorDuracionCincoADiez extends GeneradorDuracionAleatorio {

	/**
	 * Metodo que retorna un número aleatorio entre 5 y 10.
	 * @return un número aleatorio entre 5 y 10.
	 */
	public int getDuracionAleatoria() {
		int rango = (getMax() - getMin()) + 1;
		return (int) (Math.random() * rango) + getMin();
	}
	
	public GeneradorDuracionCincoADiez() {
		super(5, 10);
	}

}
