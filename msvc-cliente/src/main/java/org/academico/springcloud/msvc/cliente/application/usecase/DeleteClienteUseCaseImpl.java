package org.academico.springcloud.msvc.cliente.application.usecase;

import org.academico.springcloud.msvc.cliente.domain.port.in.DeleteClienteUseCase;
import org.academico.springcloud.msvc.cliente.domain.port.out.ClienteRepositoryPort;

/**
 * Implementación del caso de uso para eliminar un cliente.
 */
public class DeleteClienteUseCaseImpl implements DeleteClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public DeleteClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public boolean deleteCliente(Long id) {
        // Lógica de aplicación: devuelve 'true' solo si el cliente existía y fue borrado.
        return clienteRepositoryPort.buscarPorId(id).map(cliente -> {
            clienteRepositoryPort.eliminarPorId(id);
            return true;
        }).orElse(false);
    }
}
