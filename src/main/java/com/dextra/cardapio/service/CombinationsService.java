package com.dextra.cardapio.service;

import com.dextra.cardapio.entity.Combinations;

import java.util.List;
import java.util.Optional;

public interface CombinationsService {

    List<Combinations> findAll();

    Optional<Combinations> findOneById(Integer combId);

    Combinations save(Combinations combinations);

    // might not be necessary
    void delete(Integer combId);

    // --------------------- Customized -----------------------//

    /**
     * Find a Combination by name.
     *
     *
     * @param combName the desired name
     * @return the Combinations entity
     */
    Optional<Combinations> findOneByName(String combName);

    /**
     * Prepare a combination using the parsed ingredients through Array.
     *
     * @param combName the desired name
     * @param ingredientsArray ingredients array
     */
    void makeCombination(String combName, Integer[] ingredientsArray);

    Integer findLastId();
}
