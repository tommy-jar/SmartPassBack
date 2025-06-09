package com.smartpass.smartpassbackend.service;

import com.smartpass.smartpassbackend.model.Tag;
import com.smartpass.smartpassbackend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> obtenerTodos() {
        return tagRepository.findAll();
    }

    public Optional<Tag> obtenerPorId(Long id) {
        return tagRepository.findById(id);
    }

    public List<Tag> obtenerDisponibles() {
        return tagRepository.findByDisponibleTrue();
    }

    public List<Tag> obtenerOcupados() {
        return tagRepository.findByDisponibleFalse();
    }

    public Tag guardar(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag actualizar(Long numTag, Tag tag) {
        Tag existente = tagRepository.findById(numTag).orElse(null);
        if (existente != null) {
            // numTag no se actualiza porque es el ID (PK)
            existente.setDisponible(tag.getDisponible());
            existente.setPlaza(tag.getPlaza());
            existente.setFechaRegistro(tag.getFechaRegistro());
            existente.setFechaAsignacion(tag.getFechaAsignacion());
            return tagRepository.save(existente);
        }
        return null;
    }

    public void eliminar(Long numTag) {
        tagRepository.deleteById(numTag);
    }
}