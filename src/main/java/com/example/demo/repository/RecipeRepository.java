package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
