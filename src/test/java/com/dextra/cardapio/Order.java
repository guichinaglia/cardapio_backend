package com.dextra.cardapio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer order_code;

//    @ManyToMany
//    @JoinTable(name="ingredients", joinColumns = {@JoinColumn(referencedColumnName = "ID")})
//    private Ingredients ingredient;

}
