package org.academico.springcloud.msvc.venta.infrastructure.adapter.feign;

import org.academico.springcloud.msvc.venta.domain.model.Cliente;
import org.academico.springcloud.msvc.venta.domain.port.out.ClientePort;
import org.academico.springcloud.msvc.venta.infrastructure.adapter.feign.client.ClienteFeignClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteAdapter implements ClientePort {
    // Depende del ClienteFeignClient
    private final ClienteFeignClient clienteFeignClient;

    // El constructor se llama ClienteAdapter
    public ClienteAdapter(ClienteFeignClient clienteFeignClient) {
        this.clienteFeignClient = clienteFeignClient;
    }

    // El método devuelve un Optional<Cliente>
    @Override
    public Optional<Cliente> obtenerPorId(Long clienteId) {
        try {
            // Llama al método del ClienteFeignClient
            return Optional.ofNullable(clienteFeignClient.getClienteById(clienteId));
        } catch (Exception e) {
            System.err.println("Error al obtener cliente ID " + clienteId + ": " + e.getMessage());
            return Optional.empty();
        }
    }
}
