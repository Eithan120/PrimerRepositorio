package org.academico.springcloud.msvc.venta.infrastructure.adapter.jpa.mapper;

import org.academico.springcloud.msvc.venta.domain.model.ItemVenta;
import org.academico.springcloud.msvc.venta.domain.model.Venta;
import org.academico.springcloud.msvc.venta.infrastructure.adapter.jpa.entity.ItemVentaEntity;
import org.academico.springcloud.msvc.venta.infrastructure.adapter.jpa.entity.VentaEntity;

import java.util.List;
import java.util.stream.Collectors;

public class VentaMapper {
    // --- Mapeo de ItemVenta ---

    public static ItemVenta itemToDomain(ItemVentaEntity entity) {
        ItemVenta domain = new ItemVenta();
        domain.setId(entity.getId());
        domain.setProductoId(entity.getProductoId());
        domain.setCantidad(entity.getCantidad());
        domain.setPrecioUnitario(entity.getPrecioUnitario());
        domain.setSubTotal(entity.getSubTotal());
        return domain;
    }

    public static ItemVentaEntity itemToEntity(ItemVenta domain, VentaEntity ventaEntity) {
        ItemVentaEntity entity = new ItemVentaEntity();
        entity.setId(domain.getId());
        entity.setProductoId(domain.getProductoId());
        entity.setCantidad(domain.getCantidad());
        entity.setPrecioUnitario(domain.getPrecioUnitario());
        entity.setSubTotal(domain.getSubTotal());
        entity.setVenta(ventaEntity); // Establece la relación bidireccional
        return entity;
    }

    // --- Mapeo de Venta (el objeto principal) ---

    public static Venta toDomain(VentaEntity entity) {
        Venta domain = new Venta();
        domain.setId(entity.getId());
        domain.setClienteId(entity.getClienteId());
        domain.setFechaVenta(entity.getFechaVenta());
        domain.setEstadoVenta(entity.getEstadoVenta());
        domain.setMontoTotal(entity.getMontoTotal());
        if (entity.getItems() != null) {
            domain.setItems(
                    entity.getItems().stream()
                            .map(VentaMapper::itemToDomain)
                            .collect(Collectors.toList())
            );
        }
        return domain;
    }

    public static VentaEntity toEntity(Venta domain) {
        VentaEntity entity = new VentaEntity();
        entity.setId(domain.getId());
        entity.setClienteId(domain.getClienteId());
        entity.setFechaVenta(domain.getFechaVenta());
        entity.setEstadoVenta(domain.getEstadoVenta());
        entity.setMontoTotal(domain.getMontoTotal());
        if (domain.getItems() != null) {
            // Es crucial pasar la referencia 'entity' al mapear los ítems
            // para establecer la relación @ManyToOne correctamente.
            VentaEntity finalEntity = entity;
            entity.setItems(
                    domain.getItems().stream()
                            .map(itemDomain -> VentaMapper.itemToEntity(itemDomain, finalEntity))
                            .collect(Collectors.toList())
            );
        }
        return entity;
    }

    public static List<Venta> toDomainList(List<VentaEntity> entities) {
        return entities.stream().map(VentaMapper::toDomain).collect(Collectors.toList());
    }
}
