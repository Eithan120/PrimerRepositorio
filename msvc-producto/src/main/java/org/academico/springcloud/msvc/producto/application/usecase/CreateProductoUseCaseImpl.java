package org.academico.springcloud.msvc.producto.application.usecase;

import org.academico.springcloud.msvc.producto.domain.model.Producto;
import org.academico.springcloud.msvc.producto.domain.port.in.CreateProductoUseCase;
import org.academico.springcloud.msvc.producto.domain.port.out.ProductoRepositoryPort;

public class CreateProductoUseCaseImpl implements CreateProductoUseCase {
    private final ProductoRepositoryPort productoRepositoryPort;

    public CreateProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepositoryPort.guardar(producto);
    }
}
