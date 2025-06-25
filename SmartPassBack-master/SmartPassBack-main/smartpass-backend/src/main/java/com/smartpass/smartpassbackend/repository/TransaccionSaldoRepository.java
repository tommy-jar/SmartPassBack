package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.TransaccionSaldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionSaldoRepository extends JpaRepository<TransaccionSaldo, Integer> {

    @Query("SELECT t FROM TransaccionSaldo t WHERE t.idContrato = :idContrato ORDER BY t.fecha DESC")
    List<TransaccionSaldo> obtenerPorContrato(@Param("idContrato") Integer idContrato);


}
