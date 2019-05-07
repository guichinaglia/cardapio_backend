package com.dextra.cardapio.service;

import com.dextra.cardapio.entity.Ingredients;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IngredientsService {

    List<Ingredients> findAll();

    Optional<Ingredients> findOneById(Integer ingId);

    Ingredients save(Ingredients ingredients);

    void delete(Integer ingId);

    // --------------------- Customized -----------------------//

    /**
     * Find all ingredients by IDs.
     *
     * @param ingredientsIds
     * @return set of Ingredients entity
     */
    Set<Ingredients> findIngredientsByIds(Integer[] ingredientsIds);
}
