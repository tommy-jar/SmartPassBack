package com.smartpass.smartpassbackend.controller;

import com.smartpass.smartpassbackend.model.Cliente;
import com.smartpass.smartpassbackend.model.Usuario;
import com.smartpass.smartpassbackend.service.RegistroService;
import com.smartpass.smartpassbackend.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/registro")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @PostMapping("/individual")
    public void registrarUsuario(@RequestBody RegistroRequest request) {
        registroService.registrar(request.getCliente(), request.getUsuario());
    }

    // Clase interna que agrupa cliente + usuario
    public static class RegistroRequest {
        private Cliente cliente;
        private Usuario usuario;

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
    }


    @PostMapping("/empresa")
    public void registrarEmpresa(@RequestBody RegistroRequestEmpresa request) {
        registroService.registrarEmpresa(request.getCliente(), request.getUsuario());
    }
    public static class RegistroRequestEmpresa {
        private Cliente cliente;
        private Usuario usuario;

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> obtenerPerfil(@PathVariable Long idCliente) {
        Optional<Cliente> cliente = registroService.obtenerPerfil(idCliente);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<Cliente> actualizarPerfil(@PathVariable Long idCliente, @RequestBody Cliente nuevosDatos) {
        Optional<Cliente> clienteActualizado = registroService.actualizarPerfil(idCliente, nuevosDatos);
        return clienteActualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}