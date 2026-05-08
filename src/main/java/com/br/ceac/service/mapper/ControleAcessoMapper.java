package com.br.ceac.service.mapper;

import com.br.ceac.model.*;
import com.br.ceac.service.dto.*;
import org.springframework.stereotype.Component;

@Component
public class ControleAcessoMapper {

    public static ControleAcesso toEntity(ControleAcessoDTO dto) {
        if (dto == null) {
            return null;
        }

        ControleAcesso entity = new ControleAcesso();
        Portao portao = new Portao();
        Morador morador = new Morador();
        Unidade unidade = new Unidade();
        Usuario usuario = new Usuario();
        Condominio condominio = new Condominio();

        condominio.setId(dto.getMoradorDTO().getUnidade().getCondominio().getId());
        condominio.setNome(dto.getMoradorDTO().getUnidade().getCondominio().getNome());
        condominio.setEndereco(dto.getMoradorDTO().getUnidade().getCondominio().getEndereco());

        usuario.setId(dto.getMoradorDTO().getUsuario().getId());
        usuario.setUsername(dto.getMoradorDTO().getUsuario().getUsername());
        usuario.setUseremail(dto.getMoradorDTO().getUsuario().getUseremail());
//        usuario.setRoles(dto.getMoradorDTO().getUsuario().getRoles());
        usuario.setPassword(dto.getMoradorDTO().getUsuario().getPassword());

        portao.setId(dto.getPortaoDTO().getId());
        portao.setNome(dto.getPortaoDTO().getNome());

        unidade.setId(dto.getMoradorDTO().getUnidade().getId());
        unidade.setCondominio(condominio);
        unidade.setBloco(dto.getMoradorDTO().getUnidade().getBloco());
        unidade.setApartamento(dto.getMoradorDTO().getUnidade().getApartamento());

        morador.setId(dto.getMoradorDTO().getId());
        morador.setNome(dto.getMoradorDTO().getNome());
        morador.setTelefone(dto.getMoradorDTO().getTelefone());
        morador.setEmail(dto.getMoradorDTO().getEmail());
        morador.setProprietario(dto.getMoradorDTO().isProprietario());
        morador.setUnidade(unidade);
        morador.setUsuario(usuario);

        entity.setId(dto.getId());
        entity.setTag(dto.getTag());
        entity.setPortao(portao);

        return entity;
    }

    public static ControleAcessoDTO toDto(ControleAcesso entity) {
        if (entity == null) {
            return null;
        }

        ControleAcessoDTO dto = new ControleAcessoDTO();
        PortaoDTO portao = new PortaoDTO();
        MoradorDTO morador = new MoradorDTO();
        UnidadeDTO unidade = new UnidadeDTO();
        UsuarioDTO usuario = new UsuarioDTO();
        CondominioDTO condominio = new CondominioDTO();

        condominio.setId(entity.getMorador().getUnidade().getCondominio().getId());
        condominio.setNome(entity.getMorador().getUnidade().getCondominio().getNome());
        condominio.setEndereco(entity.getMorador().getUnidade().getCondominio().getEndereco());

        usuario.setId(entity.getMorador().getUsuario().getId());
        usuario.setUsername(entity.getMorador().getUsuario().getUsername());
        usuario.setUseremail(entity.getMorador().getUsuario().getUseremail());
//        usuario.setRoles(entity.getMorador().getUsuario().getRoles());
        usuario.setPassword(entity.getMorador().getUsuario().getPassword());

        portao.setId(entity.getPortao().getId());
        portao.setNome(entity.getPortao().getNome());

        unidade.setId(entity.getMorador().getUnidade().getId());
        unidade.setCondominio(condominio);
        unidade.setBloco(entity.getMorador().getUnidade().getBloco());
        unidade.setApartamento(entity.getMorador().getUnidade().getApartamento());

        morador.setId(entity.getMorador().getId());
        morador.setNome(entity.getMorador().getNome());
        morador.setTelefone(entity.getMorador().getTelefone());
        morador.setEmail(entity.getMorador().getEmail());
        morador.setProprietario(entity.getMorador().isProprietario());
        morador.setUnidade(unidade);
        morador.setUsuario(usuario);

        dto.setId(dto.getId());
        dto.setTag(dto.getTag());
        dto.setPortaoDTO(portao);

        return dto;
    }
}