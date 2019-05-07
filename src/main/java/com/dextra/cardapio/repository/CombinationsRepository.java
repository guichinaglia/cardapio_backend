package com.dextra.cardapio.repository;

import com.dextra.cardapio.entity.Combinations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CombinationsRepository extends JpaRepository<Combinations, Integer> {

    Optional<Combinations> findByCombName(String combName);

}
