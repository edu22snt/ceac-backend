package com.br.ceac.service.mapper;

import com.br.ceac.model.Condominio;
import com.br.ceac.service.dto.CondominioDTO;
import org.springframework.stereotype.Component;

@Component
public class CondominioMapper {

    public static Condominio toEntity(CondominioDTO dto) {
        if (dto == null) return null;

        Condominio entity = new Condominio();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEndereco(dto.getEndereco());

        return entity;
    }

    public static CondominioDTO toDto(Condominio entity) {
        if (entity == null) return null;

        CondominioDTO dto = new CondominioDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEndereco(entity.getEndereco());

        return dto;
    }
}
