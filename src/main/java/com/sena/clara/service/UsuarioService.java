package com.sena.clara.service;

import com.sena.clara.dto.UsuarioRequestDTO;
import com.sena.clara.dto.UsuarioResponseDTO;
import com.sena.clara.entity.Usuario;
import com.sena.clara.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO crearUsuario (UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setEdad(usuarioRequestDTO.getEdad());
        usuario.setCorreo(usuarioRequestDTO.getCorreo());

        usuarioRepository.save(usuario);

        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setEdad(usuario.getEdad());
        response.setCorreo(usuario.getCorreo());

        return response;
    }

}
