package util.exceptions;

/**
 * Esta es una clase abstracta, para definir la estructura de excepciones personalizadas dentro de la aplicación.
 *
 * @see java.lang.Exception
 * @author Daniel Jose Carrillo Herrera
 */
public abstract class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * Metodo abstracto encargado de imprimir el mensaje de error. Debe ser definido por las clases hijas de esta clase. .
	 */
	public abstract void imprimirMensajeError();
}
