package com.dextra.cardapio.service.impl;

import com.dextra.cardapio.entity.Ingredients;
import com.dextra.cardapio.entity.Orders;
import com.dextra.cardapio.enums.OrderStatusEnum;
import com.dextra.cardapio.repository.OrdersRepository;
import com.dextra.cardapio.service.IngredientsService;
import com.dextra.cardapio.service.OrdersService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository repository;

    @Autowired
    IngredientsService ingredientsService;

    @Override
    public List<Orders> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Orders> findOneById(Integer orderId) {
        return repository.findById(orderId);
    }

    @Override
    public Orders save(Orders orders) {
        return repository.save(orders);
    }

//   TODO updateStatus
//    @Override
//    public Orders updateStatus(Orders orders, OrderStatusEnum status) {
//        return repository.updateStatus(orders, status);
//    }

    @Override
    public void delete(Integer orderId) {
        repository.deleteById(orderId);
    }


    public void createTestOrder(Integer[] ingredientsArray) {
        int nextOrderCode = this.findLastOrderCode() + 1;
        int nextId = this.findLastId() + 1;
        OrderStatusEnum status = OrderStatusEnum.NEW;

        if(ingredientsArray != null) {
            Set<Ingredients> ingredientsSet = ingredientsService.findIngredientsByIds(ingredientsArray);
            Orders order = repository.save(new Orders(nextId, nextOrderCode, status, ingredientsSet));
            log.warn("-------> new test order: " + order);
        } else {
            Orders order = repository.save(new Orders(nextId, nextOrderCode, status, null));
            log.warn("-------> new test order: " + order);
        }


    }


    @Override
    public Integer findLastOrderCode() {
        int orderCode = 100;
        List<Orders> tempList = repository.findAll();
        if(!tempList.isEmpty()) {
            for (Orders tempOrders : tempList) {
                if (orderCode < tempOrders.getOrderCode()) {
                    orderCode = tempOrders.getOrderCode();
                }
            }
        }
        return orderCode;
    }

    @Override
    public Integer findLastId() {
        int lastId = 0;
        List<Orders> tempList = repository.findAll();
        if(!tempList.isEmpty()) {
            for (Orders tempOrders : tempList) {
                if (lastId < tempOrders.getOrderId()) {
                    lastId = tempOrders.getOrderId();
                }
            }
        }
        return lastId;
    }

}
