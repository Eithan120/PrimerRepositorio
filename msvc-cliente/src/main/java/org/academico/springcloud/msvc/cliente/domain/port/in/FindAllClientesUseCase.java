package org.academico.springcloud.msvc.cliente.domain.port.in;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;

import java.util.List;

public interface FindAllClientesUseCase {
    List<Cliente> findAllClientes();
}
