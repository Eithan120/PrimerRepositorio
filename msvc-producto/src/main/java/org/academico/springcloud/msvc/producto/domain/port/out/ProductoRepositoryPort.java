package org.academico.springcloud.msvc.producto.domain.port.out;

import org.academico.springcloud.msvc.producto.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(Long id);
    List<Producto> buscarTodos();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);
}