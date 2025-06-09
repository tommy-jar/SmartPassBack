package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
    List<Contrato> findByIdCliente(Integer idCliente);
}