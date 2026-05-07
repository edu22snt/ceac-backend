package com.br.ceac.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_UNIDADE")
public class Unidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_UNIDADE")
    private Long id;

    @Column(name="DS_ENDERECO")
    private String bloco;

    @Column(name="DS_APARTAMENTO")
    private String apartamento;

    @ManyToOne
    @JoinColumn(name = "CD_CONDOMINIO")
    private Condominio condominio;

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

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
