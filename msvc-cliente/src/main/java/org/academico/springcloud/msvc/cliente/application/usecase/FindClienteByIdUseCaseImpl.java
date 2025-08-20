package org.academico.springcloud.msvc.cliente.application.usecase;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;
import org.academico.springcloud.msvc.cliente.domain.port.in.FindClienteByIdUseCase;
import org.academico.springcloud.msvc.cliente.domain.port.out.ClienteRepositoryPort;

import java.util.Optional;

/**
 * Implementación del caso de uso para encontrar un cliente por su ID.
 */
public class FindClienteByIdUseCaseImpl implements FindClienteByIdUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public FindClienteByIdUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Optional<Cliente> findClienteById(Long id) {
        return clienteRepositoryPort.buscarPorId(id);
    }
}
