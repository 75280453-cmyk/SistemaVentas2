package pe.edu.continental.ventas.dominio.excepcion;

public class ReglaNegocioException extends RuntimeException {
    private final String campo;

    public ReglaNegocioException(String campo, String mensaje) {
        super(mensaje);
        this.campo = campo;
    }

    public String campo() { return campo; }
}
