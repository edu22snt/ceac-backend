package com.br.ceac.service.dto;

import java.io.Serializable;

public class ControleAcessoDTO implements Serializable {

    private Long id;
    private Long tag;
    private PortaoDTO portaoDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTag() {
        return tag;
    }

    public void setTag(Long tag) {
        this.tag = tag;
    }

    public PortaoDTO getPortaoDTO() {
        return portaoDTO;
    }

    public void setPortaoDTO(PortaoDTO portaoDTO) {
        this.portaoDTO = portaoDTO;
    }
}
