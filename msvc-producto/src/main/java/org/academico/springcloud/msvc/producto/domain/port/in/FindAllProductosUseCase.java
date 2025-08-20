package org.academico.springcloud.msvc.producto.domain.port.in;

import org.academico.springcloud.msvc.producto.domain.model.Producto;

import java.util.List;

public interface FindAllProductosUseCase {
    List<Producto> findAllProductos();
}
