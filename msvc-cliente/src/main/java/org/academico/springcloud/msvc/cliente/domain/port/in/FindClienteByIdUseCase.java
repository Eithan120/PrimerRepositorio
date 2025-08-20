package org.academico.springcloud.msvc.cliente.domain.port.in;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;

import java.util.Optional;

public interface FindClienteByIdUseCase {
    Optional<Cliente> findClienteById(Long id);
}
