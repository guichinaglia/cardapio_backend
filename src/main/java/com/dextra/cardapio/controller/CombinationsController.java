package com.dextra.cardapio.controller;

import com.dextra.cardapio.entity.Combinations;
import com.dextra.cardapio.entity.Ingredients;
import com.dextra.cardapio.service.CombinationsService;
import com.dextra.cardapio.service.IngredientsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/combinations")
@Slf4j
public class CombinationsController {

    private static final String type = MediaType.APPLICATION_JSON_VALUE;

    @Autowired
    private CombinationsService combService;

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping(value = "/", produces = type)
    public ResponseEntity<?> findAll() {
        List<Combinations> combinations = combService.findAll();
        if(combinations.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum lanche cadastrado");
        }
        return ResponseEntity.ok(combinations);
    }


    @GetMapping(value = "/{combId}", produces = type)
    public ResponseEntity<?> findOneById(@PathVariable Integer combId) {
        Optional<Combinations> combinations = combService.findOneById(combId);
        if(combinations.isPresent()) {
            return ResponseEntity.ok(combinations);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lanche não encontrado");
    }

}
