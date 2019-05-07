package com.dextra.cardapio.repository;

import com.dextra.cardapio.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Conexão direta com o banco de dados já implementando as operações CRUD ( Create, read, update, delete ).
 */
@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {
}
