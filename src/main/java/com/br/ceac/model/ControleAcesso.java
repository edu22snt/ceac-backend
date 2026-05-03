package com.br.ceac.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_CONTROLE_ACESSO")
public class ControleAcesso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_CONTROLE_ACESSO")
    private Long id;

    @Column(name="NU_TAG")
    private Long tag;

    @ManyToOne
    @JoinColumn(name = "CD_PORTAO")
    private Portao portao;

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

    public Portao getPortao() {
        return portao;
    }

    public void setPortao(Portao portao) {
        this.portao = portao;
    }
}
