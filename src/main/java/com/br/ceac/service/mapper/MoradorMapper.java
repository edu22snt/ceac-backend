package com.br.ceac.service.mapper;

import com.br.ceac.model.*;
import com.br.ceac.service.dto.*;
import org.springframework.stereotype.Component;


@Component
public class MoradorMapper {

    public static Morador toEntity(MoradorDTO dto) {
        Morador entity = new Morador();
        Usuario usuario = new Usuario();
        Veiculo veiculo = new Veiculo();
        Unidade unidade = new Unidade();
        Condominio condominio = new Condominio();

        usuario.setId(dto.getUsuarioDTO().getId());
        usuario.setPassword(dto.getUsuarioDTO().getPassword());
        usuario.setUseremail(dto.getUsuarioDTO().getUseremail());
        usuario.setUsername(dto.getUsuarioDTO().getUsername());

        veiculo.setId(dto.getVeiculoDTO().getId());
        veiculo.setTipo(dto.getVeiculoDTO().getTipo());
        veiculo.setPlaca(dto.getVeiculoDTO().getPlaca());
        veiculo.setCor(dto.getVeiculoDTO().getCor());
        veiculo.setModelo(dto.getVeiculoDTO().getModelo());

        condominio.setId(dto.getUnidadeDTO().getCondominio().getId());
        condominio.setNome(dto.getUnidadeDTO().getCondominio().getNome());
        condominio.setEndereco(dto.getUnidadeDTO().getCondominio().getEndereco());

        unidade.setId(dto.getUnidadeDTO().getId());
        unidade.setBloco(dto.getUnidadeDTO().getBloco());
        unidade.setApartamento(dto.getUnidadeDTO().getApartamento());
        unidade.setCondominio(condominio);

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());

        entity.setUsuario(usuario);
        entity.setVeiculo(veiculo);
        entity.setUnidade(unidade);
        entity.setProprietario(dto.isProprietario());
        entity.setTelefone(dto.getTelefone());

        return entity;
    }

    public static MoradorDTO toDto(Morador entity) {
        MoradorDTO dto = new MoradorDTO();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        CondominioDTO condominioDTO = new CondominioDTO();

        usuarioDTO.setId(entity.getUsuario().getId());
        usuarioDTO.setPassword(entity.getUsuario().getPassword());
        usuarioDTO.setUseremail(entity.getUsuario().getUseremail());
        usuarioDTO.setUsername(entity.getUsuario().getUsername());

        veiculoDTO.setId(entity.getVeiculo().getId());
        veiculoDTO.setTipo(entity.getVeiculo().getTipo());
        veiculoDTO.setPlaca(entity.getVeiculo().getPlaca());
        veiculoDTO.setCor(entity.getVeiculo().getCor());
        veiculoDTO.setModelo(entity.getVeiculo().getModelo());

        condominioDTO.setId(entity.getUnidade().getCondominio().getId());
        condominioDTO.setNome(entity.getUnidade().getCondominio().getNome());
        condominioDTO.setEndereco(entity.getUnidade().getCondominio().getEndereco());

        unidadeDTO.setId(entity.getUnidade().getId());
        unidadeDTO.setBloco(entity.getUnidade().getBloco());
        unidadeDTO.setApartamento(entity.getUnidade().getApartamento());
        unidadeDTO.setCondominio(condominioDTO);

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());

        dto.setUsuarioDTO(usuarioDTO);
        dto.setVeiculoDTO(veiculoDTO);
        dto.setUnidadeDTO(unidadeDTO);
        dto.setProprietario(entity.isProprietario());
        dto.setTelefone(entity.getTelefone());

        return dto;
    }

}