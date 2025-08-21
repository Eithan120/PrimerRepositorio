package org.academico.springcloud.msvc.producto.application.usecase;

import org.academico.springcloud.msvc.producto.domain.model.Producto;
import org.academico.springcloud.msvc.producto.domain.port.in.FindProductoByIdUseCase;
import org.academico.springcloud.msvc.producto.domain.port.out.ProductoRepositoryPort;

import java.util.Optional;

public class FindProductoByIdUseCaseImpl implements FindProductoByIdUseCase {
    private final ProductoRepositoryPort p;

    public FindProductoByIdUseCaseImpl(ProductoRepositoryPort p) {
        this.p = p;
    }

    @Override public Optional<Producto> findProductoById(Long id) {
        return p.buscarPorId(id);
    }
}
