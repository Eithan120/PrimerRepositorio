package org.academico.springcloud.msvc.venta.infrastructure.config;

import org.academico.springcloud.msvc.venta.application.service.VentaService;
import org.academico.springcloud.msvc.venta.application.service.VentaServiceImpl;
import org.academico.springcloud.msvc.venta.application.usecase.AsignarClienteUseCaseImpl;
import org.academico.springcloud.msvc.venta.application.usecase.CreateVentaUseCaseImpl;
import org.academico.springcloud.msvc.venta.application.usecase.FindAllVentasUseCaseImpl;
import org.academico.springcloud.msvc.venta.application.usecase.FindVentaByIdUseCaseImpl;
import org.academico.springcloud.msvc.venta.domain.port.in.AsignarClienteUseCase;
import org.academico.springcloud.msvc.venta.domain.port.in.CreateVentaUseCase;
import org.academico.springcloud.msvc.venta.domain.port.in.FindAllVentasUseCase;
import org.academico.springcloud.msvc.venta.domain.port.in.FindVentaByIdUseCase;
import org.academico.springcloud.msvc.venta.domain.port.out.ClientePort;
import org.academico.springcloud.msvc.venta.domain.port.out.ProductoPort;
import org.academico.springcloud.msvc.venta.domain.port.out.VentaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    // --- Beans para los Casos de Uso ("Trabajadores Especializados") ---
    // Spring inyectará automáticamente las implementaciones de los Puertos de Salida
    // (ClienteAdapter, ProductoAdapter, VentaRepositoryAdapter) porque tienen @Component.

    @Bean
    public CreateVentaUseCase createVentaUseCase(VentaRepositoryPort ventaRepositoryPort, ProductoPort productoPort) {
        return new CreateVentaUseCaseImpl(ventaRepositoryPort, productoPort);
    }

    @Bean
    public AsignarClienteUseCase asignarClienteUseCase(VentaRepositoryPort ventaRepositoryPort, ClientePort clientePort) {
        return new AsignarClienteUseCaseImpl(ventaRepositoryPort, clientePort);
    }

    @Bean
    public FindVentaByIdUseCase findVentaByIdUseCase(VentaRepositoryPort ventaRepositoryPort, ClientePort clientePort, ProductoPort productoPort) {
        return new FindVentaByIdUseCaseImpl(ventaRepositoryPort, clientePort, productoPort);
    }

    @Bean
    public FindAllVentasUseCase findAllVentasUseCase(VentaRepositoryPort ventaRepositoryPort, ClientePort clientePort, ProductoPort productoPort) {
        return new FindAllVentasUseCaseImpl(ventaRepositoryPort, clientePort, productoPort);
    }


    // --- Bean para la Fachada de Servicio ("Jefe de Cocina") ---
    // Este método agrupa todos los casos de uso en una sola fachada de servicio.

    @Bean
    public VentaService ventaService(
            CreateVentaUseCase createVentaUseCase,
            AsignarClienteUseCase asignarClienteUseCase,
            FindVentaByIdUseCase findVentaByIdUseCase,
            FindAllVentasUseCase findAllVentasUseCase
    ) {
        return new VentaServiceImpl(
                createVentaUseCase,
                asignarClienteUseCase,
                findVentaByIdUseCase,
                findAllVentasUseCase
        );
    }
}