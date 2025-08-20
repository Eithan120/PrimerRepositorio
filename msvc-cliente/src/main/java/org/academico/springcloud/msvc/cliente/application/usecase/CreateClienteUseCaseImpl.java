package org.academico.springcloud.msvc.cliente.application.usecase;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;
import org.academico.springcloud.msvc.cliente.domain.port.in.CreateClienteUseCase;
import org.academico.springcloud.msvc.cliente.domain.port.out.ClienteRepositoryPort;

/**
 * Implementación del caso de uso para crear un cliente.
 * Su única dependencia es el puerto de salida del repositorio, lo que la mantiene
 * desacoplada de la tecnología de persistencia.
 */

public class CreateClienteUseCaseImpl implements CreateClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    // La dependencia se inyecta a través del constructor.
    public CreateClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        // La lógica aquí es simple: delega la acción de guardado al puerto de persistencia.
        return clienteRepositoryPort.guardar(cliente);
    }
}
