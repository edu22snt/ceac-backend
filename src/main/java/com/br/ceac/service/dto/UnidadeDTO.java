package com.br.ceac.service.dto;

import java.io.Serializable;

public class UnidadeDTO implements Serializable {

    private Long id;
    private String bloco;
    private String apartamento;
    private CondominioDTO condominio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public CondominioDTO getCondominio() {
        return condominio;
    }

    public void setCondominio(CondominioDTO condominio) {
        this.condominio = condominio;
    }
}
