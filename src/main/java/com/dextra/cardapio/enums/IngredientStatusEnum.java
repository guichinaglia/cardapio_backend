package com.dextra.cardapio.enums;

public enum IngredientStatusEnum {
    ACTIVE("Ativo"),
    REMOVED("Removido");

    public final String label;

    // TODO prepare all status usage with its labels
    IngredientStatusEnum(String status) {
        this.label = status;
    }
}
