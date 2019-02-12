package util.impl;

import util.GeneradorDuracionAleatorio;
 
/**
 * Esta es una clase que implementa la clase abstracta GeneradorDuraci�nAleatorio. Genera n�meros de duraci�n desde cinco a diez.
 *
 * @see util.GeneradorDuracionAleatorio
 * @author Daniel Jose Carrillo Herrera
 */
public class GeneradorDuracionCincoADiez extends GeneradorDuracionAleatorio {

	/**
	 * Metodo que retorna un n�mero aleatorio entre 5 y 10.
	 * @return un n�mero aleatorio entre 5 y 10.
	 */
	public int getDuracionAleatoria() {
		int rango = (getMax() - getMin()) + 1;
		return (int) (Math.random() * rango) + getMin();
	}
	
	public GeneradorDuracionCincoADiez() {
		super(5, 10);
	}

}
