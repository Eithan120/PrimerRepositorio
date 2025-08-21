package org.academico.springcloud.msvc.producto.application.usecase;

import org.academico.springcloud.msvc.producto.domain.model.Producto;
import org.academico.springcloud.msvc.producto.domain.port.in.UpdateProductoUseCase;
import org.academico.springcloud.msvc.producto.domain.port.out.ProductoRepositoryPort;

import java.util.Optional;

public class UpdateProductoUseCaseImpl implements UpdateProductoUseCase {
    private final ProductoRepositoryPort p;

    public UpdateProductoUseCaseImpl(ProductoRepositoryPort p) {
        this.p = p;
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        return p.buscarPorId(id).map(prod -> {
            producto.setProductoId(id);
            return p.guardar(producto);
        });
    }
}
