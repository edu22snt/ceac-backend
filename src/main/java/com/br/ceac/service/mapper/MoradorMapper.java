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

        usuario.setId(dto.getUsuario().getId());
        usuario.setPassword(dto.getUsuario().getPassword());
        usuario.setUseremail(dto.getUsuario().getUseremail());
        usuario.setUsername(dto.getUsuario().getUsername());

        veiculo.setId(dto.getVeiculo().getId());
        veiculo.setTipo(dto.getVeiculo().getTipo());
        veiculo.setPlaca(dto.getVeiculo().getPlaca());
        veiculo.setCor(dto.getVeiculo().getCor());
        veiculo.setModelo(dto.getVeiculo().getModelo());

        condominio.setId(dto.getUnidade().getCondominio().getId());
        condominio.setNome(dto.getUnidade().getCondominio().getNome());
        condominio.setEndereco(dto.getUnidade().getCondominio().getEndereco());

        unidade.setId(dto.getUnidade().getId());
        unidade.setBloco(dto.getUnidade().getBloco());
        unidade.setApartamento(dto.getUnidade().getApartamento());
        unidade.setCondominio(condominio);

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());

        entity.setUsuario(usuario);
        entity.setVeiculo(veiculo);
        entity.setUnidade(unidade);
        entity.setProprietario(dto.isProprietario());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    public static MoradorDTO toDto(Morador entity) {
        MoradorDTO dto = new MoradorDTO();

        UsuarioDTO usuario = new UsuarioDTO();
        VeiculoDTO veiculo = new VeiculoDTO();
        UnidadeDTO unidade = new UnidadeDTO();
        CondominioDTO condominio = new CondominioDTO();

        usuario.setId(entity.getUsuario().getId());
        usuario.setPassword(entity.getUsuario().getPassword());
        usuario.setUseremail(entity.getUsuario().getUseremail());
        usuario.setUsername(entity.getUsuario().getUsername());

        veiculo.setId(entity.getVeiculo().getId());
        veiculo.setTipo(entity.getVeiculo().getTipo());
        veiculo.setPlaca(entity.getVeiculo().getPlaca());
        veiculo.setCor(entity.getVeiculo().getCor());
        veiculo.setModelo(entity.getVeiculo().getModelo());

        condominio.setId(entity.getUnidade().getCondominio().getId());
        condominio.setNome(entity.getUnidade().getCondominio().getNome());
        condominio.setEndereco(entity.getUnidade().getCondominio().getEndereco());

        unidade.setId(entity.getUnidade().getId());
        unidade.setBloco(entity.getUnidade().getBloco());
        unidade.setApartamento(entity.getUnidade().getApartamento());
        unidade.setCondominio(condominio);

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());

        dto.setUsuario(usuario);
        dto.setVeiculo(veiculo);
        dto.setUnidade(unidade);
        dto.setProprietario(entity.isProprietario());
        dto.setTelefone(entity.getTelefone());
        dto.setEmail(entity.getEmail());

        return dto;
    }

}