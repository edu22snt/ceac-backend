package com.br.ceac.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_PORTAO")
public class Portao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_PORTAO")
    private Long id;

    @Column(name="DS_NOME")
    private String nome;

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

}
