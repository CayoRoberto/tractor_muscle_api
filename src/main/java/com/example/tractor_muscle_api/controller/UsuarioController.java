package com.example.tractor_muscle_api.controller;

import com.example.tractor_muscle_api.domain.Usuario;
import com.example.tractor_muscle_api.dto.UsuarioDTO;
import com.example.tractor_muscle_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tractor_muscle/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<?> cadastrarDados(@RequestBody UsuarioDTO dados){

        try {
            Usuario usuario = usuarioService.inserirDados(dados);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
        }
//        catch (ValidadorLogin exception){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
//        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar dados usuários");
        }

    }

    @GetMapping(path = "/login")
    public ResponseEntity<Usuario> pegarDadosLogin(@RequestParam("email") String email){
        Usuario usuario = this.usuarioService.pegarUsuario(email);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping(path = "/pegar-dados")
    public ResponseEntity<Usuario> pegarUsuario(@RequestParam("email") String login){
        Usuario usuario = this.usuarioService.pegarUsuario(login);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping(path = "/existe-email")
    public ResponseEntity<Usuario> pegarUsuarioPorEmail(@RequestParam("email") String email){
        Usuario usuario = this.usuarioService.pegarUsuarioPorEmail(email);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
