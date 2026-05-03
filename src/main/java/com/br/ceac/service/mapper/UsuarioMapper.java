package com.br.ceac.service.mapper;

import com.br.ceac.model.Role;
import com.br.ceac.model.Usuario;
import com.br.ceac.service.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setId(usuarioDTO.getId());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());

        if (usuarioDTO.getRoles() != null) {
            Set<Role> roles = usuarioDTO.getRoles().stream()
                    .map(nome -> new Role(nome))
                    .collect(Collectors.toSet());

            usuario.setRoles(roles);
        }

        return usuario;
    }

    public static UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());

        if (usuario.getRoles() != null) {
            Set<String> roles = usuario.getRoles().stream()
                    .map(Role::getNome)
                    .collect(Collectors.toSet());

            usuarioDTO.setRoles(roles);
        }

        return usuarioDTO;
    }

}