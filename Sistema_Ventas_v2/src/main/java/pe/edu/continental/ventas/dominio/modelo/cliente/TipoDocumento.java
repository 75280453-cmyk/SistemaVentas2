package pe.edu.continental.ventas.dominio.modelo.cliente;

import pe.edu.continental.ventas.dominio.excepcion.DatosInvalidosException;
import pe.edu.continental.ventas.dominio.modelo.TipoDocumento;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum TipoDocumento {


DNI(8),
RUC(11);

private final int cantidadDigitos;
TipoDocumento (int cantidadDigitos){this.cantidadDigitos=cantidadDigitos;}
public int cantidadDigitos(){return cantidadDigitos;}
public static TipoDocumento deLongitud (int numero){
    return Arrays.stream(values())
            .filter(tipo -> tipo.cantidadDigitos == numero )
            .findFirst()
            .orElseThrow( ()->new DatosInvalidosException("documento",
                    "El documento debe tener 8 digitos (DNI) U 11 DIGITOS (RUC)" + "se recibieron" + numero + "."));

    }
}