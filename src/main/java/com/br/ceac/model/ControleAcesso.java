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

    @Column(name="NU_NUMERO")
    private Long numero;

    @ManyToOne
    @JoinColumn(name = "CD_PORTAO")
    private Portao portao;

    @ManyToOne
    @JoinColumn(name = "CD_MORADOR")
    private Morador morador;

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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Portao getPortao() {
        return portao;
    }

    public void setPortao(Portao portao) {
        this.portao = portao;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }
}
