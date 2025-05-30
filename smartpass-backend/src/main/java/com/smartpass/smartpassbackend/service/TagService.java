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

    public List<Tag> listarTodos() {
        return tagRepository.findAll();
    }

    public Optional<Tag> obtenerPorId(String id) {
        return tagRepository.findById(id);
    }

    public Tag guardar(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag actualizar(String id, Tag tag) {
        tag.setNumTag(id);
        return tagRepository.save(tag);
    }
}