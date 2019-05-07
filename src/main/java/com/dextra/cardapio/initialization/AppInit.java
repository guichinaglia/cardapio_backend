package com.dextra.cardapio.initialization;

import com.dextra.cardapio.entity.Ingredients;
import com.dextra.cardapio.service.CombinationsService;
import com.dextra.cardapio.service.IngredientsService;
import com.dextra.cardapio.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CombinationsService combinationsService;

    @Autowired
    private IngredientsService ingredientsService;

    @Autowired
    private OrdersService ordersService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        fillIngredients();
        fillCombinations();
        fillOrders();

    }


    private void fillIngredients() {
        /* Alface    - 0,40
         * Bacon     - 2,00
         * Hamburger - 3,00
         * Ovo       - 0,80
         * Queijo    - 1,50
         */
        ingredientsService.save(new Ingredients(1, "Alface", 0.40));
        ingredientsService.save(new Ingredients(2, "Bacon", 2.00));
        ingredientsService.save(new Ingredients(3, "Hambúrguer de Carne", 3.00));
        ingredientsService.save(new Ingredients(4, "Ovo", 0.80));
        ingredientsService.save(new Ingredients(5, "Queijo", 1.50));
    }


    private void fillCombinations() {
        /* X-Tudo       - Bacon, Hamburger, Queijo
         * X-Burger     - Hamburger, Queijo
         * X-Egg        - Ovo, Hamburger, Queijo
         * X-Egg Bacon  - Ovo, Bacon, Hamburger, queijo
         */
        combinationsService.makeCombination("X-Tudo", new Integer[] {2, 3, 5});
        combinationsService.makeCombination("X-Burger", new Integer[] {3, 5});
        combinationsService.makeCombination("X-Egg", new Integer[] {4, 3, 5});
        combinationsService.makeCombination("X-Egg Bacon", new Integer[] {4, 2, 3, 5});

    }


    private void fillOrders() {
        ordersService.createTestOrder(new Integer[] {2, 3, 5});
        ordersService.createTestOrder(new Integer[] {3, 5});
        ordersService.createTestOrder(new Integer[] {4, 3, 5});
        ordersService.createTestOrder(new Integer[] {4, 2, 3, 5});
        ordersService.createTestOrder(new Integer[] {1, 3, 4, 5}); // promoção 1 - light
        ordersService.createTestOrder(new Integer[] {3, 3, 3, 5}); // promoção 2 - muita carne
        ordersService.createTestOrder(new Integer[] {3, 3, 3, 3, 3, 3}); // promoção 2 - muita carne
        ordersService.createTestOrder(new Integer[] {3, 5, 5, 5}); // promoção 3 - muito queijo
        ordersService.createTestOrder(new Integer[] {3, 5, 5, 5, 5, 5, 5}); // promoção 3 - muito queijo
        ordersService.createTestOrder(null);

    }



}
