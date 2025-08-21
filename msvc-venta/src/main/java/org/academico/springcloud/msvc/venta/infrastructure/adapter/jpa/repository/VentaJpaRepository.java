package org.academico.springcloud.msvc.venta.infrastructure.adapter.jpa.repository;

import org.academico.springcloud.msvc.venta.infrastructure.adapter.jpa.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaJpaRepository extends JpaRepository<VentaEntity, Long> {
}
