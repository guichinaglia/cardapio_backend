package com.dextra.cardapio.entity;

import com.dextra.cardapio.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", unique = true)
    private Integer orderId;

    @Column(name = "orderCode", unique = true, length = 30)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_code_generator")
    @SequenceGenerator(name="order_code_generator", sequenceName = "order_code_seq")
    private Integer orderCode;

    @Column(name = "orderStatus")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    // TODO add ingredients
    @ManyToMany
    @JoinTable
    private Set<Ingredients> ingredients;

    // TODO timestamp as dt_inserted and dt_changed
    // maybe with:
    // @Generated(GenerationTime.ALWAYS)

}
