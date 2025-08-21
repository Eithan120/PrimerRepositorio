package org.academico.springcloud.msvc.venta.infrastructure.adapter.jpa.repository;

import org.academico.springcloud.msvc.venta.domain.model.Venta;
import org.academico.springcloud.msvc.venta.domain.port.out.VentaRepositoryPort;
import org.academico.springcloud.msvc.venta.infrastructure.adapter.jpa.mapper.VentaMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class VentaRepositoryAdapter implements VentaRepositoryPort {
    // El adaptador USA el JpaRepository
    private final VentaJpaRepository ventaJpaRepository;

    public VentaRepositoryAdapter(VentaJpaRepository ventaJpaRepository) {
        this.ventaJpaRepository = ventaJpaRepository;
    }

    // Ahora solo necesitas implementar los métodos de TU puerto, no los de Spring.
    @Override
    public Venta guardar(Venta venta) {
        var ventaEntity = VentaMapper.toEntity(venta);
        var savedEntity = ventaJpaRepository.save(ventaEntity);
        return VentaMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Venta> buscarPorId(Long id) {
        return ventaJpaRepository.findById(id).map(VentaMapper::toDomain);
    }

    @Override
    public List<Venta> buscarTodos() {
        return VentaMapper.toDomainList(ventaJpaRepository.findAll());
    }
}
