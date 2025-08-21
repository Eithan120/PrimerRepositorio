package org.academico.springcloud.msvc.producto.infraestructure.adapter.jpa.repository;

import org.academico.springcloud.msvc.producto.domain.model.Producto;
import org.academico.springcloud.msvc.producto.domain.port.out.ProductoRepositoryPort;
import org.academico.springcloud.msvc.producto.infraestructure.adapter.jpa.mapper.ProductoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {
    private final ProductoJpaRepository r;

    public ProductoRepositoryAdapter(ProductoJpaRepository r) {
        this.r = r;
    }

    @Override
    public Producto guardar(Producto p) {
        return ProductoMapper.toDomain(r.save(ProductoMapper.toEntity(p)));
    }

    @Override public Optional<Producto> buscarPorId(Long id) {
        return r.findById(id).map(ProductoMapper::toDomain);
    }

    @Override public List<Producto> buscarTodos() {
        return ProductoMapper.toDomainList(r.findAll());
    }

    @Override public void eliminarPorId(Long id) {
        r.deleteById(id);
    }

    @Override public boolean existePorId(Long id) {
        return r.existsById(id);
    }
}
