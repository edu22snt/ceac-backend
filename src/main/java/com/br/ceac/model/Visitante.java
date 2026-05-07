package com.br.ceac.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_VISITANTE")
public class Visitante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_VISITANTE")
    private Long id;

    @Column(name="DS_NOME")
    private String nome;

    @Column(name="DS_DOCUMENTO")
    private String documento;

    @Column(name="DS_TELEFONE")
    private String telefone;

    @ManyToOne
    @JoinColumn(name="CD_UNIDADE")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name="CD_VEICULO")
    private Veiculo veiculo;

    @Column(name="DT_DATA_ENTRADA")
    private LocalDateTime dataEntrada;

    @Column(name="DT_DATA_SAIDA")
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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
