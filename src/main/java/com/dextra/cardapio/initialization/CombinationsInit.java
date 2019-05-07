//package com.dextra.cardapio.initialization;
//
//
//import com.dextra.cardapio.controller.CombinationsController;
//import com.dextra.cardapio.entity.CombinationIngredients;
//import com.dextra.cardapio.entity.Combinations;
//import com.dextra.cardapio.entity.Ingredients;
//import com.dextra.cardapio.enums.CombinationStatusEnum;
//import com.dextra.cardapio.repository.CombinationIngredientsRepository;
//import com.dextra.cardapio.repository.CombinationsRepository;
//import com.dextra.cardapio.repository.IngredientsRepository;
//import com.sun.codemodel.internal.JForEach;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//@Slf4j
//public class CombinationsInit implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private CombinationsRepository combRepo;
//
//    @Autowired
//    private CombinationIngredientsRepository combIngrRepo;
//
//    @Autowired
//    private IngredientsRepository ingredientsRepository;
//
//    //@Autowired
//    //private CombinationsController controller;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        fillData();
//    }
//
//    private void fillData() {
////        Integer[] ing = {2,3,5};
////        controller.insertNewCombination("X-Tudo", ing);
//
//        Integer[] ing = {2,3,5};
//        makeCombination("X-Tudo", ing);
//
//    }
//
//    private void makeCombination(String name, Integer[] ingredientsArray) {
//        combRepo.save(new Combinations(1, name, CombinationStatusEnum.ENABLED));
//        Optional<Combinations> combination = combRepo.findByName(name);
//        log.info("----------> " + combination.get());
//        for (Integer id : ingredientsArray) {
//            Optional<Ingredients> ingredient = ingredientsRepository.findById(id);
//            if (!ingredient.isPresent()) {
//                log.error("Ingredient doesn't exist!");
//            }
//            combIngrRepo.save(new CombinationIngredients(1, combination.get(), ingredient.get()));
//        }
//    }
//}
