package com.br.ceac.service.mapper;

import com.br.ceac.model.Unidade;
import com.br.ceac.model.Veiculo;
import com.br.ceac.model.Visitante;
import com.br.ceac.service.dto.UnidadeDTO;
import com.br.ceac.service.dto.VeiculoDTO;
import com.br.ceac.service.dto.VisitanteDTO;
import org.springframework.stereotype.Component;


@Component
public class VisitanteMapper {

    public static Visitante toEntity(VisitanteDTO dto) {
        Visitante entity = new Visitante();
        Unidade unidade = new Unidade();
        Veiculo veiculo = new Veiculo();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDocumento(dto.getDocumento());
        entity.setDataEntrada(dto.getDataEntrada());
        entity.setDataSaida(dto.getDataSaida());
        entity.setUnidade(unidade);
        entity.setVeiculo(veiculo);
        return entity;
    }

    public static VisitanteDTO toDto(Visitante entity) {
        VisitanteDTO dto = new VisitanteDTO();
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        VeiculoDTO veiculoDTO = new VeiculoDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDocumento(entity.getDocumento());
        dto.setDataEntrada(entity.getDataEntrada());
        dto.setDataSaida(entity.getDataSaida());
        dto.setUnidadeDTO(unidadeDTO);
        dto.setVeiculoDTO(veiculoDTO);
        return dto;
    }

}