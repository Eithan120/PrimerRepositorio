package org.academico.springcloud.msvc.cliente.application.usecase;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;
import org.academico.springcloud.msvc.cliente.domain.port.in.UpdateClienteUseCase;
import org.academico.springcloud.msvc.cliente.domain.port.out.ClienteRepositoryPort;

import java.util.Optional;

/**
 * Implementación del caso de uso para actualizar un cliente.
 */
public class UpdateClienteUseCaseImpl implements UpdateClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public UpdateClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Optional<Cliente> updateCliente(Long id, Cliente cliente) {
        // Lógica de aplicación: solo actualiza si el cliente realmente existe.
        return clienteRepositoryPort.buscarPorId(id).map(clienteExistente -> {
            cliente.setClienteId(id); // Asegura que el ID del objeto a guardar es el correcto.
            return clienteRepositoryPort.guardar(cliente);
        });
    }
}
