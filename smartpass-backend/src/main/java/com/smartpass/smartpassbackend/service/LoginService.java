package com.smartpass.smartpassbackend.service;

import com.smartpass.smartpassbackend.model.Login;
import com.smartpass.smartpassbackend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Optional<Login> login(String dni, String password) {
        return loginRepository.findByDniAndPassword(dni, password);
    }
}