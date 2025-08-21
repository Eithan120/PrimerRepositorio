package org.academico.springcloud.msvc.producto.application.usecase;

import org.academico.springcloud.msvc.producto.domain.model.Producto;
import org.academico.springcloud.msvc.producto.domain.port.in.FindAllProductosUseCase;
import org.academico.springcloud.msvc.producto.domain.port.out.ProductoRepositoryPort;

import java.util.List;

public class FindAllProductosUseCaseImpl implements FindAllProductosUseCase {
    private final ProductoRepositoryPort p;

    public FindAllProductosUseCaseImpl(ProductoRepositoryPort p) {
        this.p = p;
    }

    @Override public List<Producto> findAllProductos() {
        return p.buscarTodos();
    }
}
