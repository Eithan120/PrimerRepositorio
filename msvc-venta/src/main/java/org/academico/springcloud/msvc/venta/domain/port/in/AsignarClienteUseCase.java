package org.academico.springcloud.msvc.venta.domain.port.in;

import org.academico.springcloud.msvc.venta.domain.model.Venta;

import java.util.Optional;

public interface AsignarClienteUseCase {
    Optional<Venta> asignarCliente(Long ventaId, Long clienteId);
}
