package pe.edu.continental.ventas.dominio.modelo;

import pe.edu.continental.ventas.dominio.excepcion.DatosInvalidosException;

import java.util.Objects;
import java.util.regex.Pattern;

//xq son reglas de negocio con final
public final class DocumentoIdentidad {
    private static final Pattern SOLO_DIGITOS = Pattern.compile("\\d+");
    private static final String CAMPO="numeroDocumeno";

    private final TipoDocumento tipo;
    private final String numero;

    private DocumentoIdentidad(TipoDocumento tipo, String numero){
        this.tipo=tipo;
        this.numero=numero;
    }
    public static DocumentoIdentidad de (TipoDocumento tipo, String numero){
        Objects.requireNonNull(tipo, "El tipo de documento es onligatorio");
        String valor = numero == null ? "" : numero.trim();
        if(valor.isEmpty()){
            throw new DatosInvalidosException(CAMPO,"El numero de documento es obligatorio");
        }
        if(!SOLO_DIGITOS.matcher(valor).matches()){
            throw new DatosInvalidosException(CAMPO, "El numero de documento admite solo digitos");
        }
        if (valor.length() != tipo.longitud()){
            throw new DatosInvalidosException(CAMPO, "El " + tipo + " debe tener " + tipo.longitud()
                    + " dígitos; se recibieron " + valor.length() + ".");
        }
        return new DocumentoIdentidad(tipo, valor);
    }
    public static DocumentoIdentidad de (String tipo, String numero){
        return de(TipoDocumento.desde(tipo),numero);
    }

    public TipoDocumento tipo() {return tipo;}
    public String numero(){return numero;}

    @Override
    public boolean equals(Object otro){

        if(this==otro){
            return true;
        }
        if(!(otro instanceof DocumentoIdentidad documento)){
            return false;
        }
        return tipo == documento.tipo && numero.equals(documento.numero);
    }

    @Override
    public int hashCode(){
        return Objects.hash(tipo, numero);
    }

    @Override
    public String toString() {
        return tipo + " " + numero;
    }
}
