package com.smartpass.smartpassbackend.service;

import com.smartpass.smartpassbackend.model.Cliente;
import com.smartpass.smartpassbackend.model.Usuario;
import com.smartpass.smartpassbackend.repository.ClienteRepository;
import com.smartpass.smartpassbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void registrar(Cliente cliente, Usuario usuario) {
        // Verificar si el cliente ya existe por número de documento
        Optional<Cliente> clienteExistente = clienteRepository.findByNumDocumento(cliente.getNumDocumento());

        Cliente clienteGuardado;

        if (clienteExistente.isPresent()) {
            clienteGuardado = clienteExistente.get();
        } else {
            cliente.setFechaCreacion(LocalDateTime.now());
            cliente.setFechaModificacion(LocalDateTime.now());
            clienteGuardado = clienteRepository.save(cliente);
        }

        // Verifica si ya existe un usuario con ese cliente (opcional)
        if (usuarioRepository.findByUsuario(usuario.getUsuario()) == null) {
            usuario.setIdCliente(clienteGuardado.getIdCliente());
            usuario.setIdRol(2);
            usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Ya existe un usuario con ese correo.");
        }
    }

    public void registrarEmpresa(Cliente cliente, Usuario usuario) {
        try {
            // Validar campos requeridos
            if (cliente.getNumDocumento() == null || cliente.getNumDocumento().isEmpty()) {
                throw new IllegalArgumentException("El RUC (numDocumento) es obligatorio.");
            }

            // Establecer fechas
            LocalDateTime ahora = LocalDateTime.now();
            cliente.setFechaCreacion(ahora);
            cliente.setFechaModificacion(ahora);

            // Guardar cliente
            Cliente clienteGuardado = clienteRepository.save(cliente);

            // Vincular cliente al usuario y asignar rol empresarial
            usuario.setIdCliente(clienteGuardado.getIdCliente());
            usuario.setIdRol(2); // 2 = empresa
            usuarioRepository.save(usuario);

        } catch (Exception e) {
            throw new RuntimeException("Error al registrar empresa: " + e.getMessage(), e);
        }
    }



}