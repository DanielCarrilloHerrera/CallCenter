package util;

public class GeneradorDuracionCincoADiez extends GeneradorDuracionAleatorio {

	
	public int getDuracionAleatoria() {
		int rango = (getMax() - getMin()) + 1;
		return (int) (Math.random() * rango) + getMin();
	}
	
	public GeneradorDuracionCincoADiez() {
		super(5, 10);
	}

}
