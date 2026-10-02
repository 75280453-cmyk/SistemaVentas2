package pe.edu.continental.ventas.dominio.repositorio;

import pe.edu.continental.ventas.dominio.modelo.Cliente;
import pe.edu.continental.ventas.dominio.modelo.cliente.NumeroDocumento;

import java.util.Optional;

public interface RepositorioClientes {
    Cliente guardar(Cliente cliente);

    boolean existePorDocumento(NumeroDocumento documento);

    Optional<Cliente> buscarPorDocumento(NumeroDocumento documento);
}
