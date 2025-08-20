package org.academico.springcloud.msvc.cliente.application.usecase;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;
import org.academico.springcloud.msvc.cliente.domain.port.in.FindAllClientesUseCase;
import org.academico.springcloud.msvc.cliente.domain.port.out.ClienteRepositoryPort;

import java.util.List;

/**
 * Implementación del caso de uso para encontrar todos los clientes.
 */
public class FindAllClientesUseCaseImpl  implements FindAllClientesUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public FindAllClientesUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepositoryPort.buscarTodos();
    }
}
