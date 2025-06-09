package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNumDocumento(String numDocumento);
}
