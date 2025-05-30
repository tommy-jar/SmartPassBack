package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.Transito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransitoRepository extends JpaRepository<Transito, Integer> {
    List<Transito> findByIdCliente(Integer idCliente);

}