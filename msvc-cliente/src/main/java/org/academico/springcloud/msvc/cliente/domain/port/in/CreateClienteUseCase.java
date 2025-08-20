package org.academico.springcloud.msvc.cliente.domain.port.in;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;

public interface CreateClienteUseCase {
    Cliente createCliente(Cliente cliente);
}