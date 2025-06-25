package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.Transito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TransitoRepository extends JpaRepository<Transito, Long> {

    @Query("SELECT t FROM Transito t WHERE t.cliente.idCliente = :idCliente AND t.fecha BETWEEN :inicio AND :fin AND t.facturado = false AND t.contrato.tipoContrato = 'POS'")
    List<Transito> findByClienteAndFecha(Long idCliente, LocalDateTime inicio, LocalDateTime fin);

    @Query("SELECT t FROM Transito t WHERE t.cliente.idCliente = :idCliente")
    List<Transito> findByIdCliente(Long idCliente);

    @Query("SELECT t FROM Transito t WHERE t.contrato.tipoContrato = :tipoContrato AND t.facturado = false")
    List<Transito> findByTipoContratoAndFacturadoFalse(@Param("tipoContrato") String tipoContrato);


}