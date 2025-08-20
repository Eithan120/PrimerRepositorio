package org.academico.springcloud.msvc.cliente.application.service;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de la fachada de servicio.
 * Agrega todos los casos de uso de cliente en un único punto de entrada para la infraestructura.
 */
public interface ClienteService {
    Cliente createCliente(Cliente cliente);
    Optional<Cliente> findClienteById(Long id);
    List<Cliente> findAllClientes();
    Optional<Cliente> updateCliente(Long id, Cliente cliente);
    boolean deleteCliente(Long id);
}