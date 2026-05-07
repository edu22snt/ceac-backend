package com.br.ceac.service.mapper;

import com.br.ceac.model.Portao;
import com.br.ceac.service.dto.PortaoDTO;
import org.springframework.stereotype.Component;

@Component
public class PortaoMapper {

    public static Portao toEntity(PortaoDTO dto) {
        Portao entity = new Portao();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }

    public static PortaoDTO toDto(Portao entity) {
        PortaoDTO dto = new PortaoDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        return dto;
    }

}