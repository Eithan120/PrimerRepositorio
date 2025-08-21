package org.academico.springcloud.msvc.producto.application.usecase;

import org.academico.springcloud.msvc.producto.domain.port.in.DeleteProductoUseCase;
import org.academico.springcloud.msvc.producto.domain.port.out.ProductoRepositoryPort;

public class DeleteProductoUseCaseImpl implements DeleteProductoUseCase {
    private final ProductoRepositoryPort p;

    public DeleteProductoUseCaseImpl(ProductoRepositoryPort p) {
        this.p = p;
    }

    @Override
    public boolean deleteProducto(Long id) {
        return p.buscarPorId(id).map(prod -> {
            p.eliminarPorId(id);
            return true;
        }).orElse(false);
    }
}

