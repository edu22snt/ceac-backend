package com.br.ceac.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VisitanteDTO implements Serializable {

    private Long id;
    private String nome;
    private String documento;
    private String telefone;
    private UnidadeDTO unidadeDTO;
    private VeiculoDTO veiculoDTO;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public UnidadeDTO getUnidadeDTO() {
        return unidadeDTO;
    }

    public void setUnidadeDTO(UnidadeDTO unidadeDTO) {
        this.unidadeDTO = unidadeDTO;
    }

    public VeiculoDTO getVeiculoDTO() {
        return veiculoDTO;
    }

    public void setVeiculoDTO(VeiculoDTO veiculoDTO) {
        this.veiculoDTO = veiculoDTO;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }
}
