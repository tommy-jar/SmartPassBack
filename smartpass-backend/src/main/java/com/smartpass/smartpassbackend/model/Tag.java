package com.smartpass.smartpassbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pro_tag")
public class Tag {

    @Id
    @Column(name = "num_tag")
    private String numTag;

    @Column(name = "disponible")
    private Boolean disponible;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;

    public String getNumTag() {
        return numTag;
    }
    public void setNumTag(String numTag) {
        this.numTag = numTag;
    }
    public Boolean getDisponible() {
        return disponible;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }
    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }


}