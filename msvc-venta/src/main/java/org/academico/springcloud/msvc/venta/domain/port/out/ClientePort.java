package org.academico.springcloud.msvc.venta.domain.port.out;

import org.academico.springcloud.msvc.venta.domain.model.Cliente;

import java.util.Optional;

public interface ClientePort {
    Optional<Cliente> obtenerPorId(Long clienteId);
}
