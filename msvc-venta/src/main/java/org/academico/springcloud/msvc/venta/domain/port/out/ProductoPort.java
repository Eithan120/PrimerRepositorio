package org.academico.springcloud.msvc.venta.domain.port.out;

import org.academico.springcloud.msvc.venta.domain.model.Producto;

import java.util.Optional;

public interface ProductoPort {
    Optional<Producto> obtenerPorId(Long productoId);
}
