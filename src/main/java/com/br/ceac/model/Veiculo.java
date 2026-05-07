package com.br.ceac.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_VEICULO")
    private Long id;

    @Column(name = "DS_PLACA", nullable = false, unique = true)
    private String placa;

    @Column(name = "DS_MODELO")
    private String modelo;

    @Column(name = "DS_MARCA")
    private String marca;

    @Column(name = "DS_COR")
    private String cor;

    @Column(name = "NR_ANO")
    private Integer ano;

    @Column(name = "DS_TIPO")
    private String tipo; // CARRO, MOTO, CAMINHONETE...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
