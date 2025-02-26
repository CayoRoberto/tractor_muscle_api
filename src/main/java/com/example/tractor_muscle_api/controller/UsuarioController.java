package com.example.tractor_muscle_api.controller;

import com.example.tractor_muscle_api.domain.Usuario;
import com.example.tractor_muscle_api.dto.UsuarioDTO;
import com.example.tractor_muscle_api.service.UsuarioService;
import com.example.tractor_muscle_api.service.validation.ValidadorLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tractor_muscle/usuario")
//@CrossOrigin(origins = "http://localhost:4200") // Permite requisições do frontend Angular
//@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<?> cadastrarDados(@RequestBody UsuarioDTO dados){

        Usuario user = new Usuario(dados);
        try {
            Usuario usuario = usuarioService.cadastrar(dados);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
        }catch (ValidadorLogin exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuário");
        }

    }

    @GetMapping(path = "/pegar-dados-login")
    public ResponseEntity<Usuario> pegarDadosLogin(@RequestParam("login") String email){
        Usuario usuario = this.usuarioService.pegarUsuario(email);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping(path = "/pegar-dados")
    public ResponseEntity<Usuario> pegarUsuario(@RequestParam("login") String login){
        Usuario usuario = this.usuarioService.pegarUsuario(login);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping(path = "/existe-email")
    public ResponseEntity<Usuario> pegarUsuarioPorEmail(@RequestParam("login") String email){
        Usuario usuario = this.usuarioService.pegarUsuarioPorEmail(email);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
