package org.academico.springcloud.msvc.producto.infraestructure.adapter.jpa.repository;

import org.academico.springcloud.msvc.producto.infraestructure.adapter.jpa.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, Long> {
}
