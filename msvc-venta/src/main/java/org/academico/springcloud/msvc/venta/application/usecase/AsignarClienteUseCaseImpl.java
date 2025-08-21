package org.academico.springcloud.msvc.venta.application.usecase;

import org.academico.springcloud.msvc.venta.domain.model.Venta;
import org.academico.springcloud.msvc.venta.domain.port.in.AsignarClienteUseCase;
import org.academico.springcloud.msvc.venta.domain.port.out.ClientePort;
import org.academico.springcloud.msvc.venta.domain.port.out.VentaRepositoryPort;

import java.util.Optional;

public class AsignarClienteUseCaseImpl implements AsignarClienteUseCase {
    private final VentaRepositoryPort ventaRepositoryPort;
    private final ClientePort clientePort;

    public AsignarClienteUseCaseImpl(VentaRepositoryPort ventaRepositoryPort, ClientePort clientePort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
        this.clientePort = clientePort;
    }

    @Override
    public Optional<Venta> asignarCliente(Long ventaId, Long clienteId) {
        // Primero, valida que el cliente exista llamando al puerto de salida
        return clientePort.obtenerPorId(clienteId).flatMap(cliente ->
                // Si el cliente existe, busca la venta
                ventaRepositoryPort.buscarPorId(ventaId).map(venta -> {
                    // Aplica la lógica de negocio y guarda
                    venta.setClienteId(cliente.getClienteId());
                    return ventaRepositoryPort.guardar(venta);
                })
        );
    }
}
