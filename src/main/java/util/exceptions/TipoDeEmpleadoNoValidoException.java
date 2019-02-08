package util.exceptions;

public class TipoDeEmpleadoNoValidoException extends CustomException {

	private static final long serialVersionUID = 1L;

	@Override
	public void imprimirMensajeError() {
		System.out.println("El tipo de empleado indicado no es correcto");
	}

}
