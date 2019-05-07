package com.dextra.cardapio.controller;

import com.dextra.cardapio.entity.Orders;
import com.dextra.cardapio.enums.OrderStatusEnum;
import com.dextra.cardapio.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrdersController {

    private static final String type = MediaType.APPLICATION_JSON_VALUE;

    @Autowired
    private OrdersService service;

    @GetMapping(value = "/", produces = type)
    public ResponseEntity<?> findAll() {
        List<Orders> orders = service.findAll();
        if (orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum pedido encontrado!");
        }
        return ResponseEntity.ok(orders);
    }


    @GetMapping(value = "/{orderId}", produces = type)
    public ResponseEntity<?> findOneById (@PathVariable Integer orderId) {
        Optional<Orders> order = service.findOneById(orderId);
        if(order.isPresent()) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }


    @PostMapping(consumes = type)
    public ResponseEntity<?> insertNew(@RequestBody Orders orders) {
        orders.setOrderStatus(OrderStatusEnum.NEW);
        Orders order = service.save(orders);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Pedido já existe");
        }
        return ResponseEntity.ok(order);
    }


    @PutMapping(value = "/{orderId}")
    public ResponseEntity<?> updateStatus (@PathVariable Integer orderId, @RequestParam OrderStatusEnum status) {
        Optional<Orders> order = service.findOneById(orderId);
        if (!order.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
        if (status == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status não encontrado");
        }
        Orders updatedOrder = order.get();
        updatedOrder.setOrderStatus(status);
        service.save(updatedOrder);
        log.warn("Updating order status:");
        log.warn("ORDER: " + updatedOrder.getOrderCode());
        log.warn("STATUS: " + status);
        return ResponseEntity.ok(updatedOrder);
    }


    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<?> delete (@PathVariable Integer orderId) {
        Optional<Orders> order = service.findOneById(orderId);
        if(!order.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
        if(order.get().getOrderId().equals(orderId)) {
            service.delete(orderId);
        }
        return ResponseEntity.ok("Deleted");
    }

}
