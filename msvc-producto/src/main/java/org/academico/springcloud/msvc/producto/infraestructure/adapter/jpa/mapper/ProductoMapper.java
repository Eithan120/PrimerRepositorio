package org.academico.springcloud.msvc.producto.infraestructure.adapter.jpa.mapper;

import org.academico.springcloud.msvc.producto.domain.model.Producto;
import org.academico.springcloud.msvc.producto.infraestructure.adapter.jpa.entity.ProductoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoMapper {

    public static Producto toDomain(ProductoEntity e) {
        Producto d = new Producto();
        d.setProductoId(e.getProductoId());
        d.setNombre(e.getNombre());
        d.setMarca(e.getMarca());
        d.setTalla(e.getTalla());
        d.setColor(e.getColor());
        d.setDescripcion(e.getDescripcion());
        d.setPrecio(e.getPrecio()); return d;
    }
    public static ProductoEntity toEntity(Producto d) {
        ProductoEntity e = new ProductoEntity();
        e.setProductoId(d.getProductoId());
        e.setNombre(d.getNombre());
        e.setMarca(d.getMarca());
        e.setTalla(d.getTalla());
        e.setColor(d.getColor());
        e.setDescripcion(d.getDescripcion());
        e.setPrecio(d.getPrecio()); return e;
    }

    public static List<Producto> toDomainList(List<ProductoEntity> es) {
        return es.stream().map(ProductoMapper::toDomain).collect(Collectors.toList());
    }
}
