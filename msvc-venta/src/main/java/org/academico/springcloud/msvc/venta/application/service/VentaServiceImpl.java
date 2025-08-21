package org.academico.springcloud.msvc.venta.application.service;

import org.academico.springcloud.msvc.venta.domain.model.Venta;
import org.academico.springcloud.msvc.venta.domain.port.in.AsignarClienteUseCase;
import org.academico.springcloud.msvc.venta.domain.port.in.CreateVentaUseCase;
import org.academico.springcloud.msvc.venta.domain.port.in.FindAllVentasUseCase;
import org.academico.springcloud.msvc.venta.domain.port.in.FindVentaByIdUseCase;

import java.util.List;
import java.util.Optional;

public class VentaServiceImpl implements VentaService {
    private final CreateVentaUseCase createVentaUseCase;
    private final AsignarClienteUseCase asignarClienteUseCase;
    private final FindVentaByIdUseCase findVentaByIdUseCase;
    private final FindAllVentasUseCase findAllVentasUseCase;

    public VentaServiceImpl(
            CreateVentaUseCase createVentaUseCase,
            AsignarClienteUseCase asignarClienteUseCase,
            FindVentaByIdUseCase findVentaByIdUseCase,
            FindAllVentasUseCase findAllVentasUseCase) {
        this.createVentaUseCase = createVentaUseCase;
        this.asignarClienteUseCase = asignarClienteUseCase;
        this.findVentaByIdUseCase = findVentaByIdUseCase;
        this.findAllVentasUseCase = findAllVentasUseCase;
    }

    @Override
    public Venta createVenta(Venta venta) {
        return createVentaUseCase.createVenta(venta);
    }

    @Override
    public Optional<Venta> asignarCliente(Long ventaId, Long clienteId) {
        return asignarClienteUseCase.asignarCliente(ventaId, clienteId);
    }

    @Override
    public Optional<Venta> findVentaById(Long id) {
        return findVentaByIdUseCase.findVentaById(id);
    }

    @Override
    public List<Venta> findAllVentas() {
        return findAllVentasUseCase.findAllVentas();
    }
}
