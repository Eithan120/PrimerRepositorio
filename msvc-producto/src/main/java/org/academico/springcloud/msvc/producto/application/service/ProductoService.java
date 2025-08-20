package org.academico.springcloud.msvc.producto.application.service;

import org.academico.springcloud.msvc.producto.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto createProducto(Producto producto);
    Optional<Producto> findProductoById(Long id);
    List<Producto> findAllProductos();
    Optional<Producto> updateProducto(Long id, Producto producto);
    boolean deleteProducto(Long id);
}
