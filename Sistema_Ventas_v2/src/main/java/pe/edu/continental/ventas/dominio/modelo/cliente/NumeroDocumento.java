package pe.edu.continental.ventas.dominio.modelo.cliente;

import pe.edu.continental.ventas.dominio.excepcion.DatosInvalidosException;
import pe.edu.continental.ventas.dominio.modelo.TipoDocumento;

import java.util.regex.Pattern;

public final class NumeroDocumento {
    private static final Pattern SOLO_DIGITOS = Pattern.compile("\\d+");
    private static final int LARGO_MAXIMO=11;

    private final String numero;
    private final TipoDocumento tipo;

    private NumeroDocumento(String numero, TipoDocumento tipo){
        this.numero=numero;
        this.tipo=tipo;
    }
    public static NumeroDocumento de (String valor){
        String normalizado = TextoObligatorio.validar("documento", valor, LARGO_MAXIMO);
        if(!SOLO_DIGITOS.matcher(normalizado).matches()){
            throw new DatosInvalidosException("documento",
                    "El documento debe contener solo digitos. Valor recibdo: '" + normalizado + "'.");
        }
        return new NumeroDocumento(normalizado,TipoDocumento.deLongitud(normalizado.length()));
    }

}