package com.dextra.cardapio.controller;


import com.dextra.cardapio.entity.Ingredients;
import com.dextra.cardapio.service.impl.IngredientsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * o controller é a conexão direta com a aplicação backend com o front end. O front end faz as chamadas e o controller é responsável por executa-las.
 */

@RestController
@RequestMapping("/ingredients")
@Slf4j
public class IngredientsController {

    private static final String type = MediaType.APPLICATION_JSON_VALUE;

    // Conecta o controller ao serviço
    @Autowired
    private IngredientsServiceImpl service;

    // Recebe todos os dados, produzindo como retorno o tipo JSON.
    @GetMapping(value = "/", produces = type)
    public ResponseEntity<?> findAll() {
        List<Ingredients> ingredients = service.findAll();
        if(ingredients.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum ingrediente cadastrado");
        }
        return ResponseEntity.ok(ingredients);
    }


    // Recebe somente um elemento do banco de dados como exemplo: ("select * from ingredients where ID = o_id"
    @GetMapping(value = "/{ingId}", produces = type)
    public ResponseEntity<?> findOneById(@PathVariable Integer ingId) {
        Optional<Ingredients> ingredient = service.findOneById(ingId);
        if(ingredient.isPresent()) {
            return ResponseEntity.ok(ingredient);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente não encontrado");
    }


    // Cria um novo elemento no banco de dados, consumindo um JSON que veio do front end.
    @PostMapping(consumes = type)
    public ResponseEntity<?> insertNew(@RequestBody Ingredients ingredients) {
        log.info("Inserting new ingredient: " + ingredients.getIngName() + " " + ingredients.getIngPrice());

        Ingredients ingredient = service.save(ingredients);
        if(ingredient == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ingrediente já existe");
        }
        return ResponseEntity.ok(ingredient);
    }


    // Atualiza um elemento no banco de dados, passando o ID e o novo elemento.
    @PutMapping(value = "/{ingId}")
    public ResponseEntity<?> update(@RequestBody Ingredients newIngredient, @PathVariable Integer ingId) {
        Optional<Ingredients> ingredient = service.findOneById(ingId);
        if(!ingredient.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        log.warn(newIngredient.getIngId().toString());
        service.save(newIngredient);
        return ResponseEntity.ok(newIngredient);
    }


    //Delete um elemento do banco de dados utilizando o ID.
    @DeleteMapping(value = "/{ingId}")
    public ResponseEntity<?> delete(@PathVariable Integer ingId) {
        Optional<Ingredients> ingredient = service.findOneById(ingId);
        if(!ingredient.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente não encontrado");
        }
        if(ingredient.get().getIngId().equals(ingId)) {
            service.delete(ingId);
        }
        return ResponseEntity.ok(ingredient);
    }

}
