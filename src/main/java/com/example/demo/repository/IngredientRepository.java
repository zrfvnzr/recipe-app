package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

	Optional<Ingredient> findByName(@Param("name") String name);
	
}
