package pe.edu.continental.ventas.dominio.modelo;

import pe.edu.continental.ventas.dominio.excepcion.DatosInvalidosException;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Cliente {
    private static final int LONGITUD_MINIMA_RAZON_SOCIAL = 3;
    private static final int LONGITUD_MAXIMA_RAZON_SOCIAL = 120;
    private static final int LONGITUD_MAXIMA_TELEFONO = 15;

    private final Long id;
    private final DocumentoIdentidad documento;
    private final String razonSocial;
    private final CorreoElectronico correo;
    private final String telefono;
    private final LocalDateTime fechaRegistro;

    private Cliente(Long id, DocumentoIdentidad documento, String razonSocial,
                    CorreoElectronico correo, String telefono, LocalDateTime fechaRegistro) {
        this.id = id;
        this.documento = Objects.requireNonNull(documento, "El documento es obligatorio");
        this.razonSocial = validarRazonSocial(razonSocial);
        this.correo = Objects.requireNonNull(correo, "El correo es obligatorio");
        this.telefono = validarTelefono(telefono);
        this.fechaRegistro = Objects.requireNonNull(fechaRegistro, "La fecha de registro es obligatoria");
    }

    public static Cliente nuevo(DocumentoIdentidad documento, String razonSocial,
                                CorreoElectronico correo, String telefono, LocalDateTime fechaRegistro) {
        return new Cliente(null, documento, razonSocial, correo, telefono, fechaRegistro);
    }

    public static Cliente existente(Long id, DocumentoIdentidad documento, String razonSocial,
                                    CorreoElectronico correo, String telefono, LocalDateTime fechaRegistro) {
        Objects.requireNonNull(id, "Un cliente existente requiere identificador");
        return new Cliente(id, documento, razonSocial, correo, telefono, fechaRegistro);
    }

    private static String validarRazonSocial(String razonSocial) {
        String valor = razonSocial == null ? "" : razonSocial.trim();
        if (valor.length() < LONGITUD_MINIMA_RAZON_SOCIAL) {
            throw new DatosInvalidosException("razonSocial",
                    "La razón social debe tener al menos " + LONGITUD_MINIMA_RAZON_SOCIAL + " caracteres");
        }
        if (valor.length() > LONGITUD_MAXIMA_RAZON_SOCIAL) {
            throw new DatosInvalidosException("razonSocial",
                    "La razón social no puede superar los " + LONGITUD_MAXIMA_RAZON_SOCIAL + " caracteres");
        }
        return valor;
    }

    private static String validarTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            return null;
        }
        String valor = telefono.trim();
        if (valor.length() > LONGITUD_MAXIMA_TELEFONO) {
            throw new DatosInvalidosException("telefono",
                    "El teléfono no puede superar los " + LONGITUD_MAXIMA_TELEFONO + " caracteres");
        }
        return valor;
    }

    public Long id() { return id; }
    public DocumentoIdentidad documento() { return documento; }
    public String razonSocial() { return razonSocial; }
    public CorreoElectronico correo() { return correo; }
    public String telefono() { return telefono; }
    public LocalDateTime fechaRegistro() { return fechaRegistro; }
}