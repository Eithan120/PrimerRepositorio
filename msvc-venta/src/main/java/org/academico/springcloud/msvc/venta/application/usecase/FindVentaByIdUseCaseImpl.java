package org.academico.springcloud.msvc.venta.application.usecase;

import org.academico.springcloud.msvc.venta.domain.model.ItemVenta;
import org.academico.springcloud.msvc.venta.domain.model.Venta;
import org.academico.springcloud.msvc.venta.domain.port.in.FindVentaByIdUseCase;
import org.academico.springcloud.msvc.venta.domain.port.out.ClientePort;
import org.academico.springcloud.msvc.venta.domain.port.out.ProductoPort;
import org.academico.springcloud.msvc.venta.domain.port.out.VentaRepositoryPort;

import java.util.Optional;

public class FindVentaByIdUseCaseImpl implements FindVentaByIdUseCase {
    private final VentaRepositoryPort ventaRepositoryPort;
    private final ClientePort clientePort;
    private final ProductoPort productoPort;

    public FindVentaByIdUseCaseImpl(VentaRepositoryPort ventaRepositoryPort, ClientePort clientePort, ProductoPort productoPort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
        this.clientePort = clientePort;
        this.productoPort = productoPort;
    }

    @Override
    public Optional<Venta> findVentaById(Long id) {
        // Busca la venta y si la encuentra, la enriquece
        return ventaRepositoryPort.buscarPorId(id).map(this::enriquecerVenta);
    }

    private Venta enriquecerVenta(Venta venta) {
        // Enriquece el cliente
        if (venta.getClienteId() != null) {
            clientePort.obtenerPorId(venta.getClienteId()).ifPresent(venta::setCliente);
        }
        // Enriquece cada producto en los ítems
        if (venta.getItems() != null) {
            for (ItemVenta item : venta.getItems()) {
                if (item.getProductoId() != null) {
                    productoPort.obtenerPorId(item.getProductoId()).ifPresent(item::setProducto);
                }
            }
        }
        return venta;
    }
}
