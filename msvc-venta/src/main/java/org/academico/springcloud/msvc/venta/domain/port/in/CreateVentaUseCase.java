package org.academico.springcloud.msvc.venta.domain.port.in;

import org.academico.springcloud.msvc.venta.domain.model.Venta;

public interface CreateVentaUseCase {
    Venta createVenta(Venta venta);
}
