package org.academico.springcloud.msvc.cliente.infrastructure.config;

import org.academico.springcloud.msvc.cliente.application.service.ClienteService;
import org.academico.springcloud.msvc.cliente.application.service.ClienteServiceImpl;
import org.academico.springcloud.msvc.cliente.application.usecase.*;
import org.academico.springcloud.msvc.cliente.domain.port.in.*;
import org.academico.springcloud.msvc.cliente.domain.port.out.ClienteRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    // --- Beans para los Casos de Uso (Los "Trabajadores") ---

    @Bean
    public CreateClienteUseCase createClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        return new CreateClienteUseCaseImpl(clienteRepositoryPort);
    }

    @Bean
    public FindClienteByIdUseCase findClienteByIdUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        return new FindClienteByIdUseCaseImpl(clienteRepositoryPort);
    }

    @Bean
    public FindAllClientesUseCase findAllClientesUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        return new FindAllClientesUseCaseImpl(clienteRepositoryPort);
    }

    @Bean
    public UpdateClienteUseCase updateClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        return new UpdateClienteUseCaseImpl(clienteRepositoryPort);
    }

    @Bean
    public DeleteClienteUseCase deleteClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        return new DeleteClienteUseCaseImpl(clienteRepositoryPort);
    }

    // --- Bean para la Fachada de Servicio (El "Jefe de Cocina") ---

    @Bean
    public ClienteService clienteService(
            CreateClienteUseCase createClienteUseCase,
            FindClienteByIdUseCase findClienteByIdUseCase,
            FindAllClientesUseCase findAllClientesUseCase,
            UpdateClienteUseCase updateClienteUseCase,
            DeleteClienteUseCase deleteClienteUseCase
    ) {
        return new ClienteServiceImpl(
                createClienteUseCase,
                findClienteByIdUseCase,
                findAllClientesUseCase,
                updateClienteUseCase,
                deleteClienteUseCase
        );
    }
}
