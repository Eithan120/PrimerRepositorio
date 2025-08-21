package org.academico.springcloud.msvc.venta.application.usecase;

import org.academico.springcloud.msvc.venta.domain.model.ItemVenta;
import org.academico.springcloud.msvc.venta.domain.model.Producto;
import org.academico.springcloud.msvc.venta.domain.model.Venta;
import org.academico.springcloud.msvc.venta.domain.port.in.CreateVentaUseCase;
import org.academico.springcloud.msvc.venta.domain.port.out.ProductoPort;
import org.academico.springcloud.msvc.venta.domain.port.out.VentaRepositoryPort;

import java.time.LocalDate;

public class CreateVentaUseCaseImpl implements CreateVentaUseCase {
    private final VentaRepositoryPort ventaRepositoryPort;
    private final ProductoPort productoPort;

    public CreateVentaUseCaseImpl(VentaRepositoryPort ventaRepositoryPort, ProductoPort productoPort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
        this.productoPort = productoPort;
    }

    @Override
    public Venta createVenta(Venta venta) {
        if (venta.getItems() == null || venta.getItems().isEmpty()) {
            throw new IllegalArgumentException("Una venta debe tener al menos un ítem.");
        }

        double montoTotalCalculado = 0.0;

        for (ItemVenta item : venta.getItems()) {
            // Se comunica con el puerto de salida para obtener los datos del producto
            Producto producto = productoPort.obtenerPorId(item.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto con ID " + item.getProductoId() + " no encontrado."));

            // Lógica de negocio: El precio se establece desde el servicio, no se confía en el cliente.
            item.setPrecioUnitario(producto.getPrecio());
            item.setSubTotal(item.getCantidad() * item.getPrecioUnitario());
            montoTotalCalculado += item.getSubTotal();
        }

        venta.setMontoTotal(montoTotalCalculado);
        venta.setFechaVenta(LocalDate.now()); // Establece la fecha actual por defecto

        return ventaRepositoryPort.guardar(venta);
    }
}
