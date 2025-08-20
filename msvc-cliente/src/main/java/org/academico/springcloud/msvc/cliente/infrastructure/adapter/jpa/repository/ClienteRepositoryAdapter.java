package org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.repository;

import org.academico.springcloud.msvc.cliente.domain.model.Cliente;
import org.academico.springcloud.msvc.cliente.domain.port.out.ClienteRepositoryPort;
import org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.entity.ClienteEntity;
import org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.mapper.ClienteMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        ClienteEntity clienteEntity = ClienteMapper.toEntity(cliente);
        ClienteEntity savedEntity = clienteJpaRepository.save(clienteEntity);
        return ClienteMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteJpaRepository.findById(id).map(ClienteMapper::toDomain);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return ClienteMapper.toDomainList(clienteJpaRepository.findAll());
    }

    @Override
    public void eliminarPorId(Long id) {
        clienteJpaRepository.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return clienteJpaRepository.existsById(id);
    }
}
