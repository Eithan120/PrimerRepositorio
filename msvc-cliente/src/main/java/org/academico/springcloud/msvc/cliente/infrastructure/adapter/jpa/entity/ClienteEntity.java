package org.academico.springcloud.msvc.cliente.infrastructure.adapter.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String nombreCompleto;

    @Column(unique = true)
    private String email;

    private String telefono;

    @Embedded
    private DireccionEmbeddable direccion;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DireccionEmbeddable getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionEmbeddable direccion) {
        this.direccion = direccion;
    }
}
