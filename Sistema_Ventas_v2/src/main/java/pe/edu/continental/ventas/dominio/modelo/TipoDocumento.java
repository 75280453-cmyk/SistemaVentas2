package pe.edu.continental.ventas.dominio.modelo;

import pe.edu.continental.ventas.dominio.excepcion.DatosInvalidosException;

//enum sin final
public enum TipoDocumento {
    DNI(8),
    RUC(11);

    private final int longitud;
    TipoDocumento (int longitud){this.longitud=longitud;}
    public int longitud(){return longitud;}
    public static TipoDocumento desde (String valor){
        if (valor==null || valor.isBlank()){
            throw new DatosInvalidosException("tipoDocumento","El tipo de documento esobligatorio");
        }
        try{
            return TipoDocumento.valueOf((valor.trim().toUpperCase()));
        }catch (IllegalArgumentException e){
            throw new DatosInvalidosException("tipoDocumento","Tipo de documento no admitido: '" + valor + "'.Valores validos: DNI,RUC");
        }
    }
}
