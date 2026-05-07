package com.br.ceac.service.mapper;

import com.br.ceac.model.Veiculo;
import com.br.ceac.service.dto.VeiculoDTO;
import org.springframework.stereotype.Component;


@Component
public class VeiculoMapper {

    public static Veiculo toEntity(VeiculoDTO dto) {
        Veiculo entity = new Veiculo();

        entity.setId(dto.getId());
        entity.setPlaca(dto.getPlaca());
        entity.setModelo(dto.getModelo());
        entity.setMarca(dto.getMarca());
        entity.setCor(dto.getCor());
        entity.setCor(dto.getCor());
        entity.setAno(dto.getAno());
        entity.setTipo(dto.getTipo());

        return entity;
    }

    public static VeiculoDTO toDto(Veiculo entity) {
        VeiculoDTO dto = new VeiculoDTO();

        dto.setId(entity.getId());
        dto.setPlaca(entity.getPlaca());
        dto.setModelo(entity.getModelo());
        dto.setMarca(entity.getMarca());
        dto.setCor(entity.getCor());
        dto.setCor(entity.getCor());
        dto.setAno(entity.getAno());
        dto.setTipo(entity.getTipo());

        return dto;
    }

}