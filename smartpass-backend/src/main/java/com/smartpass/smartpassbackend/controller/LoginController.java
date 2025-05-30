package com.smartpass.smartpassbackend.controller;

import com.smartpass.smartpassbackend.model.Login;
import com.smartpass.smartpassbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String documento = credentials.get("documento");
        String password = credentials.get("password");

        Optional<Login> login = loginService.login(documento, password);

        if (login.isPresent()) {
            return ResponseEntity.ok(login.get());
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}