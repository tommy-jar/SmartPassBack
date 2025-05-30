package com.smartpass.smartpassbackend.service;

import com.smartpass.smartpassbackend.model.Contrato;
import com.smartpass.smartpassbackend.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> listarContratos() {
        return contratoRepository.findAll();
    }

    public List<Contrato> obtenerContratosPorCliente(Integer idCliente) {
        return contratoRepository.findByIdCliente(idCliente);
    }

    public Optional<Contrato> obtenerContratoPorId(Integer id) {
        return contratoRepository.findById(id);
    }

    public Contrato guardarContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public void eliminarContrato(Integer id) {
        contratoRepository.deleteById(id);
    }
}