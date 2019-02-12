package util.exceptions;

/**
 * Clase que implementa a la clase abstracta CustomException. Define un tipo de error que consiste en un tipo de empleado no valido.
 *
 * @see util.exceptions.CustomException
 * @author Daniel Jose Carrillo Herrera
 */

public class TipoDeEmpleadoNoValidoException extends CustomException {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo encargado de imprimir el mensaje de error para esta excepción personalizada.
	 */
	@Override
	public void imprimirMensajeError() {
		System.out.println("El tipo de empleado indicado no es correcto");
	}

}
