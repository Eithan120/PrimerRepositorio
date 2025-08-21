package org.academico.springcloud.msvc.producto.domain.port.in;

import org.academico.springcloud.msvc.producto.domain.model.Producto;

public interface CreateProductoUseCase {
    Producto createProducto(Producto producto);
}
