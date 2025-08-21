package org.academico.springcloud.msvc.venta.infrastructure.adapter.feign.client;

import org.academico.springcloud.msvc.venta.domain.model.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-productos", url = "http://localhost:8092/api/productos")
public interface ProductoFeignClient {
    @GetMapping("/{id}")
    Producto getProductoById(@PathVariable Long id);
}
