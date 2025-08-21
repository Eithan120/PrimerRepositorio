package org.academico.springcloud.msvc.venta.domain.port.in;

import org.academico.springcloud.msvc.venta.domain.model.Venta;

import java.util.List;

public interface FindAllVentasUseCase {
    List<Venta> findAllVentas();
}
