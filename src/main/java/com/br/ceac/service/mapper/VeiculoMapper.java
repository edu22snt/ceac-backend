package com.br.ceac.service.mapper;

import com.br.ceac.model.Veiculo;
import com.br.ceac.service.dto.VeiculoDTO;
import org.springframework.stereotype.Component;


@Component
public class VeiculoMapper {

    public static Veiculo toEntity(VeiculoDTO dto) {
        Veiculo entity = new Veiculo();

        entity.setId(dto.getId());
        entity.setModelo(dto.getModelo());
        entity.setCor(dto.getCor());
        entity.setPlaca(dto.getPlaca());
        entity.setTipo(dto.getTipo());
        return entity;
    }

    public static VeiculoDTO toDto(Veiculo entity) {
        VeiculoDTO dto = new VeiculoDTO();

        dto.setId(entity.getId());
        dto.setModelo(entity.getModelo());
        dto.setCor(entity.getCor());
        dto.setPlaca(entity.getPlaca());
        dto.setTipo(entity.getTipo());

        return dto;
    }

}