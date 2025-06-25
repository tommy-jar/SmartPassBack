package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
    List<Contrato> findByIdCliente(Integer idCliente);


    @Query("SELECT c.idContrato AS idContrato, c.nroContrato AS nroContrato " +
            "FROM Contrato c " +
            "WHERE c.tipoContrato = 'PRE' AND c.idCliente = :idCliente")
    List<ContratoInfo> obtenerContratosPrepagoPorCliente(@Param("idCliente") Integer idCliente);
}