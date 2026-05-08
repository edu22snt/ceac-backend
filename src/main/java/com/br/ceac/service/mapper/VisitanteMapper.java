package com.br.ceac.service.mapper;

import com.br.ceac.model.Condominio;
import com.br.ceac.model.Unidade;
import com.br.ceac.model.Veiculo;
import com.br.ceac.model.Visitante;
import com.br.ceac.service.dto.CondominioDTO;
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
        Condominio condominio = new Condominio();

        condominio.setId(dto.getUnidade().getCondominio().getId());
        condominio.setNome(dto.getUnidade().getCondominio().getNome());
        condominio.setEndereco(dto.getUnidade().getCondominio().getEndereco());

        unidade.setId(dto.getUnidade().getId());
        unidade.setBloco(dto.getUnidade().getBloco());
        unidade.setApartamento(dto.getUnidade().getApartamento());
        unidade.setCondominio(condominio);

        veiculo.setId(dto.getVeiculo().getId());
        veiculo.setAno(dto.getVeiculo().getAno());
        veiculo.setCor(dto.getVeiculo().getCor());
        veiculo.setMarca(dto.getVeiculo().getMarca());
        veiculo.setModelo(dto.getVeiculo().getModelo());
        veiculo.setPlaca(dto.getVeiculo().getPlaca());
        veiculo.setTipo(dto.getVeiculo().getTipo());

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setDocumento(dto.getDocumento());
        entity.setTelefone(dto.getTelefone());
        entity.setDataEntrada(dto.getDataEntrada());
        entity.setUnidade(unidade);
        entity.setVeiculo(veiculo);
        return entity;
    }

    public static VisitanteDTO toDto(Visitante entity) {
        VisitanteDTO dto = new VisitanteDTO();
        UnidadeDTO unidade = new UnidadeDTO();
        VeiculoDTO veiculo = new VeiculoDTO();
        CondominioDTO condominio = new CondominioDTO();

        condominio.setId(entity.getUnidade().getCondominio().getId());
        condominio.setNome(entity.getUnidade().getCondominio().getNome());
        condominio.setEndereco(entity.getUnidade().getCondominio().getEndereco());

        unidade.setId(entity.getUnidade().getId());
        unidade.setBloco(entity.getUnidade().getBloco());
        unidade.setApartamento(entity.getUnidade().getApartamento());
        unidade.setCondominio(condominio);

        veiculo.setId(entity.getVeiculo().getId());
        veiculo.setAno(entity.getVeiculo().getAno());
        veiculo.setCor(entity.getVeiculo().getCor());
        veiculo.setMarca(entity.getVeiculo().getMarca());
        veiculo.setModelo(entity.getVeiculo().getModelo());
        veiculo.setPlaca(entity.getVeiculo().getPlaca());
        veiculo.setTipo(entity.getVeiculo().getTipo());

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDocumento(entity.getDocumento());
        dto.setTelefone(entity.getTelefone());
        dto.setDataEntrada(entity.getDataEntrada());
        dto.setTipoDocumento(entity.getTipoDocumento());
        dto.setUnidade(unidade);
        dto.setVeiculo(veiculo);
        return dto;
    }

}