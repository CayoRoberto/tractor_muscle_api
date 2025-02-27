package com.example.tractor_muscle_api.controller;

import com.example.tractor_muscle_api.domain.Usuario;


import com.example.tractor_muscle_api.dto.AuthDTO;
import com.example.tractor_muscle_api.service.security.DateTokenJWT;
import com.example.tractor_muscle_api.service.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tractor_muscle/login")
@CrossOrigin(origins = "http://localhost:4200")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AuthDTO dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return  ResponseEntity.ok(new DateTokenJWT(tokenJWT));
    }
}
