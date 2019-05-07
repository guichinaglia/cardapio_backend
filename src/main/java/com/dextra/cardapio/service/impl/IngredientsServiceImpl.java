package com.dextra.cardapio.service.impl;

import com.dextra.cardapio.entity.Ingredients;
import com.dextra.cardapio.repository.IngredientsRepository;
import com.dextra.cardapio.service.IngredientsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Implementação do serviço em si.
 * Pode-se fazer a regra de negócio aqui caso queira salvar. Caso contrário, se for somente dados temporarios,
 * EX: ( Cálculo rápido do valor à pagar, somente para demonstrativo ) pode-se fazer no controller.
 */
@Slf4j
@Service
public class IngredientsServiceImpl implements IngredientsService {

    // Conecta o serviço ao repositorio.
    @Autowired
    private IngredientsRepository repository;

    @Override
    public List<Ingredients> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Ingredients> findOneById(Integer ingId) {
        return repository.findById(ingId);
    }

    @Override
    public Ingredients save(Ingredients ingredients) {
        return repository.save(ingredients);
    }

    @Override
    public void delete(Integer ingId) {
        repository.deleteById(ingId);
    }

    @Override
    public Set<Ingredients> findIngredientsByIds(Integer[] ingredientsIds) {
        Set<Ingredients> ingredientsSet = new HashSet<>();

        for (int id : ingredientsIds) {
            Optional<Ingredients> ingredient = repository.findById(id);
            if (!ingredient.isPresent()) {
                log.error("Ingredient doesn't exist!");
                ingredientsSet.clear();
                return ingredientsSet;
            }
            log.warn("valor " + ingredient.get());

            ingredientsSet.add(ingredient.get());
        }
        return ingredientsSet;
    }



}
