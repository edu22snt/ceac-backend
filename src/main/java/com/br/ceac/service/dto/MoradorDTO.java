package com.br.ceac.service.dto;

import java.io.Serializable;

public class MoradorDTO implements Serializable {

    private Long id;
    private String nome;
    private UsuarioDTO usuarioDTO;
    private VeiculoDTO veiculoDTO;
    private UnidadeDTO unidadeDTO;
    private boolean proprietario;
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public VeiculoDTO getVeiculoDTO() {
        return veiculoDTO;
    }

    public void setVeiculoDTO(VeiculoDTO veiculoDTO) {
        this.veiculoDTO = veiculoDTO;
    }

    public UnidadeDTO getUnidadeDTO() {
        return unidadeDTO;
    }

    public void setUnidadeDTO(UnidadeDTO unidadeDTO) {
        this.unidadeDTO = unidadeDTO;
    }

    public boolean isProprietario() {
        return proprietario;
    }

    public void setProprietario(boolean proprietario) {
        this.proprietario = proprietario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
