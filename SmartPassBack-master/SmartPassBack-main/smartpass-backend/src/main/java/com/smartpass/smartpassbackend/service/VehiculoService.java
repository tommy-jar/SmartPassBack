package com.smartpass.smartpassbackend.service;

import com.smartpass.smartpassbackend.model.Vehiculo;
import com.smartpass.smartpassbackend.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.findAll();
    }

    // Listar vehículos por cliente
    public List<Vehiculo> obtenerVehiculosPorCliente(Long idCliente) {
        return vehiculoRepository.findByCliente_IdCliente(idCliente);
    }

    public List<Vehiculo> obtenerVehiculosPorDocumento(String documento) {
        return vehiculoRepository.findByCliente_NumDocumento(documento);
    }

    public void desafiliarVehiculo(Long idVehiculo) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        vehiculo.setIdEstado(2); // 2 = desafiliado
        vehiculoRepository.save(vehiculo);
    }



    public Optional<Vehiculo> obtenerPorId(Long id) {
        return vehiculoRepository.findById(id);
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo actualizar(Integer id, Vehiculo vehiculo) {
        vehiculo.setIdVehiculo(id);
        return vehiculoRepository.save(vehiculo);
    }
}