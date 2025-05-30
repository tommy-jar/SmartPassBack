package com.smartpass.smartpassbackend.controller;

import com.smartpass.smartpassbackend.model.Vehiculo;
import com.smartpass.smartpassbackend.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> listarTodos() {
        return vehiculoService.listarTodos();
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Vehiculo> listarVehiculosPorCliente(@PathVariable Integer idCliente) {
        return vehiculoService.obtenerVehiculosPorCliente(idCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerPorId(@PathVariable Integer id) {
        return vehiculoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vehiculo crear(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.guardar(vehiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizar(@PathVariable Integer id, @RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(vehiculoService.actualizar(id, vehiculo));
    }
}