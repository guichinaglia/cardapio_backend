package com.dextra.cardapio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Currency;


/**
 * @Data: Indica a criação de get e set
 * @Entity: Indica a criação de uma entidade que será traduzida em uma tabela de banco da dados
 * @AllArgsConstructor: Cria um construtor com todas as variaves Ex: Ingredients(Integer id, String name, String price ) {}
        * @NotArgsConstructor: Cria um construtor sem parametros Ex: Ingredients() {}
        */

@Data
@Entity(name = "ingredients")
@Table(name = "ingredients")
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingId", nullable = false)
    private Integer ingId;

    @Column(name = "ingName", nullable = false, length = 30)
    @NotEmpty
    private String ingName;

    @Column(name = "ingPrice")
    @NotNull
    private Double ingPrice; //TODO: Change the type of price to a number.

}
