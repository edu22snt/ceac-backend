package com.br.ceac.service.mapper;

import com.br.ceac.model.Condominio;
import com.br.ceac.model.Unidade;
import com.br.ceac.service.dto.CondominioDTO;
import com.br.ceac.service.dto.UnidadeDTO;
import org.springframework.stereotype.Component;

@Component
public class UnidadeMapper {

    public static Unidade toEntity(UnidadeDTO dto) {
        if (dto == null) return null;

        Unidade entity = new Unidade();
        Condominio condominio = new Condominio();

        entity.setId(dto.getId());
        entity.setBloco(dto.getBloco());
        entity.setApartamento(dto.getApartamento());
        entity.setCondominio(condominio);

        return entity;
    }

    public static UnidadeDTO toDto(Unidade entity) {
        if (entity == null) return null;

        UnidadeDTO dto = new UnidadeDTO();
        CondominioDTO condominioDTO = new CondominioDTO();

        dto.setId(entity.getId());
        dto.setBloco(entity.getBloco());
        dto.setApartamento(entity.getApartamento());
        dto.setCondominioDTO(condominioDTO);

        return dto;
    }
}
