package org.academico.springcloud.msvc.producto.domain.port.in;

import org.academico.springcloud.msvc.producto.domain.model.Producto;

import java.util.Optional;

public interface FindProductoByIdUseCase {
    Optional<Producto> findProductoById(Long id);
}
