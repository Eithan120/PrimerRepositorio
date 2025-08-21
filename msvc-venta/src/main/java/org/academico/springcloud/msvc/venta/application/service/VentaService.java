package org.academico.springcloud.msvc.venta.application.service;

import org.academico.springcloud.msvc.venta.domain.model.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaService {
    Optional<Venta> asignarCliente(Long ventaId, Long clienteId);
    Venta createVenta(Venta venta);
    List<Venta> findAllVentas();
    Optional<Venta> findVentaById(Long id);
}
