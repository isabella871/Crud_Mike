package com.sena.clara.controller;

import com.sena.clara.dto.UsuarioRequestDTO;
import com.sena.clara.dto.UsuarioResponseDTO;
import com.sena.clara.service.UsuarioService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // maneja peticiones HTTP(GET, POST PUT, DELETE)
@RequiredArgsConstructor
@RequestMapping("/usuarios/")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("crear") // endpoints => postman
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponseDTO response = usuarioService.crearUsuario(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("listar")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuario(){
        List<UsuarioResponseDTO> response = usuarioService.ListarUsuarios();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUserID(@PathVariable Long id){
        UsuarioResponseDTO usuario = usuarioService.buscarUserID(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }
}
