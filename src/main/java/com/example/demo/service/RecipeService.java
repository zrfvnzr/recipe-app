package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Recipe;
import com.example.demo.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
	
	public ResponseEntity<?> index() {
		return new ResponseEntity<>(recipeRepository.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> store(Recipe recipe) {
		try {
			return new ResponseEntity<Recipe>(recipeRepository.save(recipe), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> update(Long id, Recipe updatedRecipe) {
		try {
			Optional<Recipe> oldRecipe = recipeRepository.findById(id);
			if (!oldRecipe.isPresent()) {
				throw new Exception("Invalid recipe ID");
			} else {
				updatedRecipe.setId(id);
				return new ResponseEntity<Recipe>(recipeRepository.save(updatedRecipe), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> destroy(Long id) {
		try {
			Optional<Recipe> recipe = recipeRepository.findById(id);
			if (!recipe.isPresent()) {
				throw new Exception("Invalid recipe ID");
			} else {
				recipeRepository.deleteById(id);
				return new ResponseEntity<Optional<Recipe>>(recipe, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}
}
