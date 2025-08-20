package org.academico.springcloud.msvc.cliente.domain.port.in;

public interface DeleteClienteUseCase {
    boolean deleteCliente(Long id);
}