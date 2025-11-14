package com.sena.clara.controller;

import com.sena.clara.dto.UsuarioRequestDTO;
import com.sena.clara.dto.UsuarioResponseDTO;
import com.sena.clara.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // maneja peticiones HTTP(GET, POST PUT, DELETE)
@RequiredArgsConstructor
@RequestMapping("/usuarios/")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("crear")
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponseDTO response = usuarioService.crearUsuario(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
