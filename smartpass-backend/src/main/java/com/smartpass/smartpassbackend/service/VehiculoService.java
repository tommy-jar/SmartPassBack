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
    public List<Vehiculo> obtenerVehiculosPorCliente(Integer idCliente) {
        return vehiculoRepository.findByIdCliente(idCliente);
    }



    public Optional<Vehiculo> obtenerPorId(Integer id) {
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