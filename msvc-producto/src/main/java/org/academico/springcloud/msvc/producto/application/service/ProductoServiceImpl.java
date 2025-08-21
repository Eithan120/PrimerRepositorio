package org.academico.springcloud.msvc.producto.application.service;

import org.academico.springcloud.msvc.producto.domain.model.Producto;
import org.academico.springcloud.msvc.producto.domain.port.in.*;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {
    private final CreateProductoUseCase createProductoUseCase;
    private final FindProductoByIdUseCase findProductoByIdUseCase;
    private final FindAllProductosUseCase findAllProductosUseCase;
    private final UpdateProductoUseCase updateProductoUseCase;
    private final DeleteProductoUseCase deleteProductoUseCase;

    public ProductoServiceImpl(
            CreateProductoUseCase createProductoUseCase,
            FindProductoByIdUseCase findProductoByIdUseCase,
            FindAllProductosUseCase findAllProductosUseCase,
            UpdateProductoUseCase updateProductoUseCase,
            DeleteProductoUseCase deleteProductoUseCase) {
        this.createProductoUseCase = createProductoUseCase;
        this.findProductoByIdUseCase = findProductoByIdUseCase;
        this.findAllProductosUseCase = findAllProductosUseCase;
        this.updateProductoUseCase = updateProductoUseCase;
        this.deleteProductoUseCase = deleteProductoUseCase;
    }

    @Override
    public Producto createProducto(Producto producto) {
        return createProductoUseCase.createProducto(producto);
    }

    @Override
    public Optional<Producto> findProductoById(Long id) {
        return findProductoByIdUseCase.findProductoById(id);
    }

    @Override
    public List<Producto> findAllProductos() {
        return findAllProductosUseCase.findAllProductos();
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        return updateProductoUseCase.updateProducto(id, producto);
    }

    @Override
    public boolean deleteProducto(Long id) {
        return deleteProductoUseCase.deleteProducto(id);
    }
}