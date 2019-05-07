package com.dextra.cardapio.entity;

import com.dextra.cardapio.enums.CombinationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "combinations")
@Table(name = "combinations")
@AllArgsConstructor
@NoArgsConstructor
public class Combinations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "combId", unique = true, nullable = false)
    private Integer combId;

    @Column(name = "combName", unique = true, nullable = false, length = 30)
    private String combName;

    @Column(name = "combStatus") // TODO prepare a table to enable or disable it
    @Enumerated(EnumType.STRING)
    private CombinationStatusEnum combStatus;

    @ManyToMany
    @JoinTable
    private Set<Ingredients> ingredients;

}
