package org.academico.springcloud.msvc.cliente.application.service;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;
import org.academico.springcloud.msvc.cliente.domain.port.in.*;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la fachada de servicio (el "Jefe de Cocina").
 * Su única responsabilidad es conocer a todos los casos de uso especializados
 * y delegarles el trabajo.
 */
//Acá también puedes poner implements CreateClienteUseCase, FindClienteByIdUseCase, UpdateClienteUseCase, DeleteClienteUseCase, FindAllClientesUseCase
public class ClienteServiceImpl implements ClienteService {
    // Depende de las interfaces de los casos de uso, no de sus implementaciones.
    private final CreateClienteUseCase createClienteUseCase;
    private final FindClienteByIdUseCase findClienteByIdUseCase;
    private final FindAllClientesUseCase findAllClientesUseCase;
    private final UpdateClienteUseCase updateClienteUseCase;
    private final DeleteClienteUseCase deleteClienteUseCase;

    // Recibe todos los "trabajadores especializados" a través del constructor.
    public ClienteServiceImpl(CreateClienteUseCase createClienteUseCase, FindClienteByIdUseCase findClienteByIdUseCase, FindAllClientesUseCase findAllClientesUseCase, UpdateClienteUseCase updateClienteUseCase, DeleteClienteUseCase deleteClienteUseCase) {
        this.createClienteUseCase = createClienteUseCase;
        this.findClienteByIdUseCase = findClienteByIdUseCase;
        this.findAllClientesUseCase = findAllClientesUseCase;
        this.updateClienteUseCase = updateClienteUseCase;
        this.deleteClienteUseCase = deleteClienteUseCase;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        // Delega la llamada al especialista en creación.
        return createClienteUseCase.createCliente(cliente);
    }

    @Override
    public Optional<Cliente> findClienteById(Long id) {
        // Delega la llamada al especialista en búsqueda por ID.
        return findClienteByIdUseCase.findClienteById(id);
    }

    @Override
    public List<Cliente> findAllClientes() {
        // Delega la llamada al especialista en listar todo.
        return findAllClientesUseCase.findAllClientes();
    }

    @Override
    public Optional<Cliente> updateCliente(Long id, Cliente cliente) {
        // Delega la llamada al especialista en actualización.
        return updateClienteUseCase.updateCliente(id, cliente);
    }

    @Override
    public boolean deleteCliente(Long id) {
        // Delega la llamada al especialista en eliminación.
        return deleteClienteUseCase.deleteCliente(id);
    }
}
