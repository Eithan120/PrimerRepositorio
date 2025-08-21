package org.academico.springcloud.msvc.venta.application.usecase;

import org.academico.springcloud.msvc.venta.domain.model.Venta;
import org.academico.springcloud.msvc.venta.domain.port.in.FindAllVentasUseCase;
import org.academico.springcloud.msvc.venta.domain.port.out.ClientePort;
import org.academico.springcloud.msvc.venta.domain.port.out.ProductoPort;
import org.academico.springcloud.msvc.venta.domain.port.out.VentaRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllVentasUseCaseImpl implements FindAllVentasUseCase {
    private final VentaRepositoryPort ventaRepositoryPort;
    private final ClientePort clientePort;
    private final ProductoPort productoPort;

    public FindAllVentasUseCaseImpl(VentaRepositoryPort ventaRepositoryPort, ClientePort clientePort, ProductoPort productoPort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
        this.clientePort = clientePort;
        this.productoPort = productoPort;
    }

    @Override
    public List<Venta> findAllVentas() {
        // Busca todas las ventas y las enriquece una por una
        return ventaRepositoryPort.buscarTodos().stream()
                .map(this::enriquecerVenta)
                .collect(Collectors.toList());
    }

    private Venta enriquecerVenta(Venta venta) {
        if (venta.getClienteId() != null) {
            clientePort.obtenerPorId(venta.getClienteId()).ifPresent(venta::setCliente);
        }
        if (venta.getItems() != null) {
            venta.getItems().forEach(item ->
                    productoPort.obtenerPorId(item.getProductoId()).ifPresent(item::setProducto)
            );
        }
        return venta;
    }
}
