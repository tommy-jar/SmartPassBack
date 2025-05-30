package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    List<Vehiculo> findByIdCliente(Integer idCliente);
}