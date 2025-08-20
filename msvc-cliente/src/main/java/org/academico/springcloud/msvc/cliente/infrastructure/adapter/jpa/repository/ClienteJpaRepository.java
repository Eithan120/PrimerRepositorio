package org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.repository;

import org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {
}
