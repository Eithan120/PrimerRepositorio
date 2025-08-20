package org.academico.springcloud.msvc.cliente.domain.port.out;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de Salida (Output Port) que define el contrato para la persistencia de datos de Clientes.
 * La capa de infraestructura (adapter) deberá proporcionar una implementación concreta de esta interfaz.
 */

public interface ClienteRepositoryPort {
    /**
     * Guarda o actualiza un cliente en la persistencia.
     * @param cliente El objeto de dominio Cliente a guardar.
     * @return El cliente guardado (puede incluir un ID generado).
     */
    Cliente guardar(Cliente cliente);

    /**
     * Busca un cliente por su ID.
     * @param id El ID del cliente a buscar.
     * @return Un Optional que contiene el cliente si se encuentra, o está vacío si no.
     */
    Optional<Cliente> buscarPorId(Long id);

    /**
     * Devuelve una lista de todos los clientes.
     * @return Una lista de objetos Cliente.
     */
    List<Cliente> buscarTodos();

    /**
     * Elimina un cliente por su ID.
     * @param id El ID del cliente a eliminar.
     */
    void eliminarPorId(Long id);

    /**
     * Verifica si un cliente con un ID específico existe.
     * @param id El ID del cliente a verificar.
     * @return true si el cliente existe, false en caso contrario.
     */
    boolean existePorId(Long id);
}
