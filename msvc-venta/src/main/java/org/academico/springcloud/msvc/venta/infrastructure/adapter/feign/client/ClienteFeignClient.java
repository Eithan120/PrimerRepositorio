package org.academico.springcloud.msvc.venta.infrastructure.adapter.feign.client;

import org.academico.springcloud.msvc.venta.domain.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-cliente", url = "http://localhost:8091/api/cliente")
public interface ClienteFeignClient {
    @GetMapping("/{id}")
    Cliente getClienteById(@PathVariable Long id);
}
