package com.dextra.cardapio.enums;

public enum CombinationStatusEnum {
    ENABLED("Ativo"),
    DISABLED("Desabilitado");

    public final String label;

    // TODO prepare all order status usage with its labels
    CombinationStatusEnum(String status) {
        this.label = status;
    }
}
