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
public class    TagController {

    @Autowired
    private TagService tagService;

    // Obtener todos los TAGs
    @GetMapping
    public ResponseEntity<List<Tag>> obtenerTodosLosTags() {
        List<Tag> tags = tagService.obtenerTodos();
        return ResponseEntity.ok(tags);
    }

    // Obtener solo TAGs disponibles
    @GetMapping("/disponibles")
    public ResponseEntity<List<Tag>> obtenerTagsDisponibles() {
        List<Tag> disponibles = tagService.obtenerDisponibles();
        return ResponseEntity.ok(disponibles);
    }

    // Obtener solo TAGs ocupados
    @GetMapping("/ocupados")
    public ResponseEntity<List<Tag>> obtenerTagsOcupados() {
        List<Tag> ocupados = tagService.obtenerOcupados();
        return ResponseEntity.ok(ocupados);
    }

    // Guardar un nuevo TAG
    @PostMapping
    public ResponseEntity<Tag> registrarTag(@RequestBody Tag tag) {
        Tag nuevo = tagService.guardar(tag);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> obtenerPorId(@PathVariable Long id) {
        return tagService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> actualizar(@PathVariable Long id, @RequestBody Tag tag) {
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

    // Actualizar TAG existente
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Tag> actualizarTag(@PathVariable Long id, @RequestBody Tag tag) {
        Tag actualizado = tagService.actualizar(id, tag);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar TAG por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTag(@PathVariable Long id) {
        tagService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
