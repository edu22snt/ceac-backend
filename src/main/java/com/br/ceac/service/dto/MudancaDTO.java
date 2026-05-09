package com.br.ceac.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MudancaDTO implements Serializable {

    private Long id;
    private MoradorDTO morador;
    private String tipo;
    private LocalDateTime data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoradorDTO getMorador() {
        return morador;
    }

    public void setMorador(MoradorDTO morador) {
        this.morador = morador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
