package com.smartpass.smartpassbackend.controller;

import com.smartpass.smartpassbackend.model.Tag;
import com.smartpass.smartpassbackend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tags")
@CrossOrigin(origins = "http://localhost:4200")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<Tag> listarTodos() {
        return tagService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> obtenerPorId(@PathVariable String id) {
        return tagService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tag crear(@RequestBody Tag tag) {
        return tagService.guardar(tag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> actualizar(@PathVariable String id, @RequestBody Tag tag) {
        Optional<Tag> tagExistente = tagService.obtenerPorId(id);
        if (tagExistente.isPresent()) {
            Tag t = tagExistente.get();
            t.setDisponible(tag.getDisponible());
            t.setFechaAsignacion(tag.getFechaAsignacion());
            return ResponseEntity.ok(tagService.guardar(t));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
