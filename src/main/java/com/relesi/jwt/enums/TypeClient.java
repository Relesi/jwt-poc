package com.relesi.jwt.enums;

public enum TypeClient {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoal Jurídica");

    private int cod;
    private String descricao;

    private TypeClient(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;

    }

    public int getCod() {
        return cod;
    }

    public String getDescricacao() {
        return descricao;
    }

    public static TypeClient toEnum(Integer cod, String encode) {

        if (cod == null) {
            return null;
        }
        for(TypeClient x : TypeClient.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido" + cod);
    }
}
