package pe.edu.continental.ventas.dominio.excepcion;
// se lanza cuando un dato recibido no satisface la restriccion del dominio
public class DatosInvalidosException extends ReglaNegocioException {
    public DatosInvalidosException(String campo, String mensaje) {
        super(campo, mensaje);
    }
}
