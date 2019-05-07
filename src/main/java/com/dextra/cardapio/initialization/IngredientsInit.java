//package com.dextra.cardapio.initialization;
//
//
//import com.dextra.cardapio.entity.Ingredients;
//import com.dextra.cardapio.repository.IngredientsRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//
//
///**
// * Executa esta classe ao subir à aplicação.
// */
//@Component
//@Slf4j
//public class IngredientsInit implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    IngredientsRepository repo; // Poderia usar também o serviço ao invés do repositório.
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//
//        fillData();
//    }
//
//    private void fillData() {
//
////        CurrencyUnit real = Monetary.getCurrency("BRL");
////        MonetaryAmount amount = Money.of(0.40, real);
////
////        log.warn(String.valueOf(amount));
////        log.warn(String.valueOf((Money) amount));
//
////
//        repo.save(new Ingredients(1, "Alface", "0,40"));
//        repo.save(new Ingredients(2, "Bacon", "2,00"));
//        repo.save(new Ingredients(3, "Hambúrguer de Carne", "3,00"));
//        repo.save(new Ingredients(4, "Ovo", "0,80"));
//        repo.save(new Ingredients(5, "Queijo", "1,50"));
//
////        repo.save(new Ingredients(4, "Ovo", new BigDecimal(0.80)));
////        repo.save(new Ingredients(5, "Queijo", new BigDecimal(1.50)));
//
//    }
//
//}
