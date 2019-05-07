package com.dextra.cardapio.service.impl;

import com.dextra.cardapio.entity.Combinations;
import com.dextra.cardapio.entity.Ingredients;
import com.dextra.cardapio.enums.CombinationStatusEnum;
import com.dextra.cardapio.repository.CombinationsRepository;
import com.dextra.cardapio.repository.IngredientsRepository;
import com.dextra.cardapio.service.CombinationsService;
import com.dextra.cardapio.service.IngredientsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CombinationsServiceImpl implements CombinationsService {


    // -------------------- Repositories --------------------

    @Autowired
    private CombinationsRepository combRepo;

    @Autowired
    private IngredientsRepository ingredientsRepository;


    // ---------------------- Services ----------------------

    @Autowired
    private CombinationsService combinationsService;

    @Autowired
    private IngredientsService ingredientsService;

    @Override
    public List<Combinations> findAll() {
        return combRepo.findAll();
    }


    // ---------------------- Methods ----------------------

    @Override
    public Optional<Combinations> findOneById(Integer combId) {
        return combRepo.findById(combId);
    }


    @Override
    public Combinations save(Combinations combinations) {
        return combRepo.save(combinations);
    }


    @Override
    public void delete(Integer combId) {
        combRepo.deleteById(combId);
    }


    @Override
    public Optional<Combinations> findOneByName(String combName) {
        return combRepo.findByCombName(combName);
    }


    @Override
    public void makeCombination(String combName, Integer[] ingredientsArray) {
        Optional<Combinations> tempComb = combinationsService.findOneByName(combName);
        if (tempComb.isPresent()) {
            log.error("This name is already used!");
            return;
        }

        Set<Ingredients> ingredientsSet = ingredientsService.findIngredientsByIds(ingredientsArray);

        int nextCombId = this.findLastId() + 1;
        Combinations combination = combRepo.save(
                new Combinations(nextCombId, combName, CombinationStatusEnum.ENABLED, ingredientsSet)
        );
        log.warn("----------> Combination: " + combination);
    }


    @Override
    public Integer findLastId() {
        int lastId = 0;
        List<Combinations> tempList = combinationsService.findAll();
        if(!tempList.isEmpty()) {
            for (Combinations tempCombinations : tempList) {
                if (lastId < tempCombinations.getCombId()) {
                    lastId = tempCombinations.getCombId();
                }
            }
        }
        return lastId;
    }


}
