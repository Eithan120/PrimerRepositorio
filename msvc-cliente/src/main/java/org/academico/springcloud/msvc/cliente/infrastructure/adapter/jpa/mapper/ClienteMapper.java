package org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.mapper;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;
import org.academico.springcloud.msvc.cliente.domain.model.Direccion;
import org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.entity.ClienteEntity;
import org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.entity.DireccionEmbeddable;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

    public static Cliente toDomain(ClienteEntity entity) {
        Cliente domain = new Cliente();
        domain.setClienteId(entity.getClienteId());
        domain.setNombreCompleto(entity.getNombreCompleto());
        domain.setEmail(entity.getEmail());
        domain.setTelefono(entity.getTelefono());
        if (entity.getDireccion() != null) {
            Direccion direccion = new Direccion();
            direccion.setCodigoPostal(entity.getDireccion().getCodigoPostal());
            direccion.setCiudad(entity.getDireccion().getCiudad());
            direccion.setCalle(entity.getDireccion().getCalle());
            domain.setDireccion(direccion);
        }
        return domain;
    }

    public static List<Cliente> toDomainList(List<ClienteEntity> entities) {
        return entities.stream().map(ClienteMapper::toDomain).collect(Collectors.toList());
    }

    public static ClienteEntity toEntity(Cliente domain) {
        ClienteEntity entity = new ClienteEntity();
        entity.setClienteId(domain.getClienteId());
        entity.setNombreCompleto(domain.getNombreCompleto());
        entity.setEmail(domain.getEmail());
        entity.setTelefono(domain.getTelefono());
        if (domain.getDireccion() != null) {
            DireccionEmbeddable direccion = new DireccionEmbeddable();
            direccion.setCodigoPostal(domain.getDireccion().getCodigoPostal());
            direccion.setCiudad(domain.getDireccion().getCiudad());
            direccion.setCalle(domain.getDireccion().getCalle());
            entity.setDireccion(direccion);
        }
        return entity;
    }
}
