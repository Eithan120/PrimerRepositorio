package org.academico.springcloud.msvc.venta.infrastructure.adapter.feign;

import org.academico.springcloud.msvc.venta.domain.model.Producto;
import org.academico.springcloud.msvc.venta.domain.port.out.ProductoPort;
import org.academico.springcloud.msvc.venta.infrastructure.adapter.feign.client.ProductoFeignClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductoAdapter implements ProductoPort {
    private final ProductoFeignClient productoFeignClient;

    public ProductoAdapter(ProductoFeignClient productoFeignClient) {
        this.productoFeignClient = productoFeignClient;
    }

    @Override
    public Optional<Producto> obtenerPorId(Long productoId) {
        try {
            return Optional.ofNullable(productoFeignClient.getProductoById(productoId));
        } catch (Exception e) {
            System.err.println("Error al obtener producto ID " + productoId + ": " + e.getMessage());
            return Optional.empty();
        }
    }
}
