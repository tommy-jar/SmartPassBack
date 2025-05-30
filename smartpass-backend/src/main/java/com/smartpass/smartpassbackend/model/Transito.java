package com.smartpass.smartpassbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pro_transitos")
public class Transito {

    @Id
    @Column(name = "tr_id")
    private int id;

    @Column(name = "tr_plaza")
    private int plaza;

    @Column(name = "tr_fecha")
    private LocalDateTime fecha;

    @Column(name = "tr_placa")
    private String placa;

    @Column(name = "tr_categoria")
    private int categoria;

    @Column(name = "tr_via")
    private int via;

    @Column(name = "tr_monto")
    private double monto;

    @Column(name = "tr_igv")
    private double igv;

    @Column(name = "id_vehiculo")
    private int idVehiculo;

    @Column(name = "id_cliente")
    private Integer idCliente;

    // Getters y Setters


    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getVia() {
        return via;
    }

    public void setVia(int via) {
        this.via = via;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
}