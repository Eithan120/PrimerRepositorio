package org.academico.springcloud.msvc.producto.infraestructure.config;

import org.academico.springcloud.msvc.producto.application.service.ProductoService;
import org.academico.springcloud.msvc.producto.application.service.ProductoServiceImpl;
import org.academico.springcloud.msvc.producto.application.usecase.*;
import org.academico.springcloud.msvc.producto.domain.port.in.*;
import org.academico.springcloud.msvc.producto.domain.port.out.ProductoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateProductoUseCase createProductoUseCase(ProductoRepositoryPort productoRepositoryPort) {
        return new CreateProductoUseCaseImpl(productoRepositoryPort);
    }

    @Bean
    public FindProductoByIdUseCase findProductoByIdUseCase(ProductoRepositoryPort productoRepositoryPort) {
        return new FindProductoByIdUseCaseImpl(productoRepositoryPort);
    }

    @Bean
    public FindAllProductosUseCase findAllProductosUseCase(ProductoRepositoryPort productoRepositoryPort) {
        return new FindAllProductosUseCaseImpl(productoRepositoryPort);
    }

    @Bean
    public UpdateProductoUseCase updateProductoUseCase(ProductoRepositoryPort productoRepositoryPort) {
        return new UpdateProductoUseCaseImpl(productoRepositoryPort);
    }

    @Bean
    public DeleteProductoUseCase deleteProductoUseCase(ProductoRepositoryPort productoRepositoryPort) {
        return new DeleteProductoUseCaseImpl(productoRepositoryPort);
    }

    // --- Bean para la Fachada de Servicio ("Jefe de Cocina") ---
    // SOLO HAY UN BEAN PARA EL SERVICIO, CON EL NOMBRE CORRECTO

    @Bean
    public ProductoService productoService(
            CreateProductoUseCase createProductoUseCase,
            FindProductoByIdUseCase findProductoByIdUseCase,
            FindAllProductosUseCase findAllProductosUseCase,
            UpdateProductoUseCase updateProductoUseCase,
            DeleteProductoUseCase deleteProductoUseCase
    ) {
        return new ProductoServiceImpl(
                createProductoUseCase,
                findProductoByIdUseCase,
                findAllProductosUseCase,
                updateProductoUseCase,
                deleteProductoUseCase
        );
    }
}
