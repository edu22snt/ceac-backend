package com.br.ceac.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_CONDOMINIO")
public class Condominio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_CONDOMINIO")
    private Long id;

    @Column(name="DS_NOME")
    private String nome;

    @Column(name="DS_ENDERECO")
    private String endereco;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
