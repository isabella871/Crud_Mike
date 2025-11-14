package com.sena.clara.service;

import com.sena.clara.dto.UsuarioRequestDTO;
import com.sena.clara.dto.UsuarioResponseDTO;
import com.sena.clara.entity.Usuario;
import com.sena.clara.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<UsuarioResponseDTO> ListarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> response = new ArrayList<>();

        for (Usuario usuario: usuarios){
            UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
            responseDTO.setId(usuario.getId());
            responseDTO.setNombre(usuario.getNombre());
            responseDTO.setEdad(usuario.getEdad());
            responseDTO.setCorreo(usuario.getCorreo());

            response.add(responseDTO);
        }
        return response;
    }

    public UsuarioResponseDTO buscarUserID(Long id){
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontado"));
        
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
        responseDTO.setId(usuario.getId());
        responseDTO.setNombre(usuario.getNombre());
        responseDTO.setEdad(usuario.getEdad());
        responseDTO.setCorreo(usuario.getCorreo());

        return responseDTO;
    }

    public void eliminarUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("El usuario no ha sido encontrado"));

        usuarioRepository.delete(usuario);
    }
}
