package com.dextra.cardapio.enums;

public enum OrderStatusEnum {
    NEW("Novo"),
    PREPARING("Preparando"),
    FINISHED("Finalizado"),
    CANCELED("Cancelado");

    public final String label;

    // TODO prepare all order status usage with its labels
    OrderStatusEnum(String status) {
        this.label = status;
    }

}
