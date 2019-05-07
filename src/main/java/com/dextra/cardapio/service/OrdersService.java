package com.dextra.cardapio.service;

import com.dextra.cardapio.entity.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<Orders> findAll();

    Optional<Orders> findOneById(Integer orderId);

    Orders save(Orders orders);

    void delete(Integer orderId);

    // --------------------- Customized -----------------------//

    /**
     * Creates a TestOrder using an Ingredients Array.
     *
     * @param ingredientsArray the Ingredients ID (may be null).
     */
    void createTestOrder(Integer[] ingredientsArray);

    /**
     * Find last OrderCode.
     * (The higher value)
     *
     * @return last OrderCode.
     */
    Integer findLastOrderCode();

    /**
     * Find the last ID.
     * (The higher value)
     *
     * @return last ID.
     */
    Integer findLastId();
}
