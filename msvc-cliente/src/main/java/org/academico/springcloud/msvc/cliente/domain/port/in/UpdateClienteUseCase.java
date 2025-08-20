package org.academico.springcloud.msvc.cliente.domain.port.in;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;

import java.util.Optional;

public interface UpdateClienteUseCase {
    Optional<Cliente> updateCliente(Long id, Cliente cliente);
}
