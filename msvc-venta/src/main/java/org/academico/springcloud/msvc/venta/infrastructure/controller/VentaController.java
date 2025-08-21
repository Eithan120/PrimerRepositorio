package org.academico.springcloud.msvc.venta.infrastructure.controller;

import org.academico.springcloud.msvc.venta.application.service.VentaService;
import org.academico.springcloud.msvc.venta.domain.model.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        return new ResponseEntity<>(ventaService.createVenta(venta), HttpStatus.CREATED);
    }

    @PutMapping("/{ventaId}/asignar-cliente/{clienteId}")
    public ResponseEntity<Venta> asignarCliente(
            @PathVariable Long ventaId,
            @PathVariable Long clienteId) {
        return ventaService.asignarCliente(ventaId, clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscarVentaPorId(@PathVariable Long id) {
        return ventaService.findVentaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        return ResponseEntity.ok(ventaService.findAllVentas());
    }
}
