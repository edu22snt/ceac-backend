package com.br.ceac.service.mapper;

import com.br.ceac.model.*;
import com.br.ceac.service.dto.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MudancaMapper {

    public static Mudanca toEntity(MudancaDTO dto) {
        Mudanca entity = new Mudanca();
        Unidade unidade = new Unidade();
        Morador morador = new Morador();
        Veiculo veiculo = new Veiculo();
        Usuario usuario = new Usuario();

        Condominio condominio = new Condominio();

        condominio.setId(dto.getMorador().getUnidade().getCondominio().getId());
        condominio.setNome(dto.getMorador().getUnidade().getCondominio().getNome());
        condominio.setEndereco(dto.getMorador().getUnidade().getCondominio().getEndereco());

        unidade.setId(dto.getMorador().getUnidade().getId());
        unidade.setBloco(dto.getMorador().getUnidade().getBloco());
        unidade.setApartamento(dto.getMorador().getUnidade().getApartamento());
        unidade.setCondominio(condominio);

        usuario.setId(dto.getMorador().getUsuario().getId());
        usuario.setPassword(dto.getMorador().getUsuario().getPassword());
        usuario.setUsername(dto.getMorador().getUsuario().getUsername());
        usuario.setUseremail(dto.getMorador().getUsuario().getUseremail());

        veiculo.setId(dto.getMorador().getVeiculo().getId());
        veiculo.setAno(dto.getMorador().getVeiculo().getAno());
        veiculo.setCor(dto.getMorador().getVeiculo().getCor());
        veiculo.setMarca(dto.getMorador().getVeiculo().getMarca());
        veiculo.setModelo(dto.getMorador().getVeiculo().getModelo());
        veiculo.setPlaca(dto.getMorador().getVeiculo().getPlaca());
        veiculo.setTipo(dto.getMorador().getVeiculo().getTipo());

        morador.setUsuario(usuario);
        morador.setProprietario(dto.getMorador().isProprietario());
        morador.setUnidade(unidade);
        morador.setVeiculo(veiculo);
        morador.setNome(dto.getMorador().getNome());
        morador.setEmail(dto.getMorador().getEmail());
        morador.setId(dto.getMorador().getId());

        entity.setId(dto.getId());
        entity.setMorador(morador);
        entity.setTipo(dto.getTipo());
        entity.setData(dto.getData());
        return entity;
    }

    public static MudancaDTO toDto(Mudanca entity) {
        MudancaDTO dto = new MudancaDTO();
        UnidadeDTO unidade = new UnidadeDTO();
        MoradorDTO morador = new MoradorDTO();
        VeiculoDTO veiculo = new VeiculoDTO();
        UsuarioDTO usuario = new UsuarioDTO();

        CondominioDTO condominio = new CondominioDTO();

        condominio.setId(entity.getMorador().getUnidade().getCondominio().getId());
        condominio.setNome(entity.getMorador().getUnidade().getCondominio().getNome());
        condominio.setEndereco(entity.getMorador().getUnidade().getCondominio().getEndereco());

        unidade.setId(entity.getMorador().getUnidade().getId());
        unidade.setBloco(entity.getMorador().getUnidade().getBloco());
        unidade.setApartamento(entity.getMorador().getUnidade().getApartamento());
        unidade.setCondominio(condominio);

        usuario.setId(entity.getMorador().getUsuario().getId());
        usuario.setPassword(entity.getMorador().getUsuario().getPassword());
        usuario.setUsername(entity.getMorador().getUsuario().getUsername());
        usuario.setUseremail(entity.getMorador().getUsuario().getUseremail());

        veiculo.setId(entity.getMorador().getVeiculo().getId());
        veiculo.setAno(entity.getMorador().getVeiculo().getAno());
        veiculo.setCor(entity.getMorador().getVeiculo().getCor());
        veiculo.setMarca(entity.getMorador().getVeiculo().getMarca());
        veiculo.setModelo(entity.getMorador().getVeiculo().getModelo());
        veiculo.setPlaca(entity.getMorador().getVeiculo().getPlaca());
        veiculo.setTipo(entity.getMorador().getVeiculo().getTipo());

        morador.setUsuario(usuario);
        morador.setProprietario(entity.getMorador().isProprietario());
        morador.setUnidade(unidade);
        morador.setVeiculo(veiculo);
        morador.setNome(entity.getMorador().getNome());
        morador.setEmail(entity.getMorador().getEmail());
        morador.setId(entity.getMorador().getId());

        dto.setId(entity.getId());
        dto.setMorador(morador);
        dto.setTipo(entity.getTipo());
        dto.setData(entity.getData());
        return dto;
    }

}