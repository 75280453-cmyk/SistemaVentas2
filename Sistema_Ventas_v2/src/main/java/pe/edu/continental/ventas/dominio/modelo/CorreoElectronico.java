package pe.edu.continental.ventas.dominio.modelo;

import pe.edu.continental.ventas.dominio.excepcion.DatosInvalidosException;

import java.util.Objects;
import java.util.regex.Pattern;

public final class CorreoElectronico {
    private static final Pattern FORMATO = Pattern.compile("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$");
    private static final int LONGITUD_MAXIMA = 120;
    private static final String CAMPO = "correo";

    private final String valor;

    private CorreoElectronico(String valor) {
        this.valor = valor;
    }

    public static CorreoElectronico de(String correo) {
        String valor = correo == null ? "" : correo.trim().toLowerCase();
        if (valor.isEmpty()) {
            throw new DatosInvalidosException(CAMPO, "El correo es obligatorio");
        }
        if (valor.length() > LONGITUD_MAXIMA) {
            throw new DatosInvalidosException(CAMPO,
                    "El correo no puede superar los " + LONGITUD_MAXIMA + " caracteres");
        }
        if (!FORMATO.matcher(valor).matches()) {
            throw new DatosInvalidosException(CAMPO,
                    "El correo '" + correo + "' no tiene un formato válido");
        }
        return new CorreoElectronico(valor);
    }

    public String valor() { return valor; }

    @Override
    public boolean equals(Object otro) {
        return otro instanceof CorreoElectronico correo && valor.equals(correo.valor);
    }

    @Override
    public int hashCode() { return Objects.hash(valor); }

    @Override
    public String toString() { return valor; }
}
