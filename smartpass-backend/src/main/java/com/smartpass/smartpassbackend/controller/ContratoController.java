package com.smartpass.smartpassbackend.controller;

import com.smartpass.smartpassbackend.model.Contrato;
import com.smartpass. smartpassbackend.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
@CrossOrigin(origins = "http://localhost:4200")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> listar() {
        return contratoService.listarContratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> obtenerPorId(@PathVariable Integer id) {
        return contratoService.obtenerContratoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contrato> crear(@RequestBody Contrato contrato) {
        Contrato nuevo = contratoService.guardarContrato(contrato);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> actualizar(@PathVariable Integer id, @RequestBody Contrato contrato) {
        if (!contratoService.obtenerContratoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contrato.setIdContrato(id);
        return ResponseEntity.ok(contratoService.guardarContrato(contrato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (!contratoService.obtenerContratoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contratoService.eliminarContrato(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Contrato> getContratosPorCliente(@PathVariable Integer idCliente) {
        return contratoService.obtenerContratosPorCliente(idCliente);
    }
}