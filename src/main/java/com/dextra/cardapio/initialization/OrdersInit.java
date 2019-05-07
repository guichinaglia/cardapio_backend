//package com.dextra.cardapio.initialization;
//
//import com.dextra.cardapio.controller.OrdersController;
//import com.dextra.cardapio.entity.Orders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrdersInit implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    OrdersController controller;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        fillData();
//    }
//
//    private void fillData() {
//        controller.insertNew(new Orders());
//        controller.insertNew(new Orders());
//    }
//
//}
