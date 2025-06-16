package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar por usuario (correo o nombre de usuario)
    Usuario findByUsuario(String usuario);

    // Buscar por usuario y contraseña (para login, si aplica)
    Usuario findByUsuarioAndPassword(String usuario, String password);
}