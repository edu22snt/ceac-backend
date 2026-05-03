package com.br.ceac.enumerate;

public enum TipoVeiculoEnum {

    CARRO(1),
    MOTO(2),
    VAN(3);

    private final int tipo;

    TipoVeiculoEnum(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

}
