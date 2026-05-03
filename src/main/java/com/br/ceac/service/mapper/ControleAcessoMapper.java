package com.br.ceac.service.mapper;

import com.br.ceac.model.ControleAcesso;
import com.br.ceac.model.Portao;
import com.br.ceac.service.dto.ControleAcessoDTO;
import com.br.ceac.service.dto.PortaoDTO;
import org.springframework.stereotype.Component;

@Component
public class ControleAcessoMapper {

    public static ControleAcesso toEntity(ControleAcessoDTO dto) {
        if (dto == null) {
            return null;
        }

        ControleAcesso entity = new ControleAcesso();
        Portao portao = new Portao();

        portao.setId(dto.getPortaoDTO().getId());
        portao.setNome(dto.getPortaoDTO().getNome());
        portao.setNumero(dto.getPortaoDTO().getNumero());

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
        PortaoDTO portaoDTO = new PortaoDTO();

        portaoDTO.setId(entity.getPortao().getId());
        portaoDTO.setNome(entity.getPortao().getNome());
        portaoDTO.setNumero(entity.getPortao().getNumero());

        dto.setId(dto.getId());
        dto.setTag(dto.getTag());
        dto.setPortaoDTO(portaoDTO);

        return dto;
    }
}