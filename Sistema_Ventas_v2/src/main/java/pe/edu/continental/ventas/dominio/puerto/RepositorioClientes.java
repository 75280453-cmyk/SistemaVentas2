package pe.edu.continental.ventas.dominio.puerto;

import pe.edu.continental.ventas.dominio.modelo.Cliente;
import pe.edu.continental.ventas.dominio.modelo.DocumentoIdentidad;

import java.util.List;
import java.util.Optional;

public interface RepositorioClientes {
    Cliente guardar(Cliente cliente);
    boolean existePorDocumento (DocumentoIdentidad documento);
    Optional<Cliente> buscarPorDocumento (DocumentoIdentidad documentoIdentidad);
    List<Cliente> listarTodos();
}
