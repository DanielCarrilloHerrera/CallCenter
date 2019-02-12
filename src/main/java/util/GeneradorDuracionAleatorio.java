package util;

/**
 * Esta es una clase abstracta encargada de definir la estructura de un generador de duraciones de llamadas aleatorias..
 *
 * @see java.lang.Object
 * @author Daniel Jose Carrillo Herrera
 */
 public abstract class GeneradorDuracionAleatorio {
	
	private int max;
	private int min;
	
	/**
	 * Constructor para definir el Generador de tipo aleatorio.
	 * @param min que define la duración minima aleatoria que se puede generar.
	 * @param max que define la duración máxima aleatoria que se puede generar.
	 */
	public GeneradorDuracionAleatorio(int min, int max) {
		super();
		this.max = max;
		this.min = min;
	}

	

	public int getMax() {
		return max;
	}



	public void setMax(int max) {
		this.max = max;
	}



	public int getMin() {
		return min;
	}



	public void setMin(int min) {
		this.min = min;
	}



	public abstract int getDuracionAleatoria();
}
