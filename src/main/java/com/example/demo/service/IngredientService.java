package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Ingredient;
import com.example.demo.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;
	
	public ResponseEntity<?> index() {
		try {
			return new ResponseEntity<Iterable<Ingredient>>(ingredientRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> store(Ingredient ingredient) {
		try {
			Optional<Ingredient> oldIngredient = ingredientRepository.findByName(ingredient.getName());
			if (oldIngredient.isPresent()) {
				oldIngredient.get().setAmount(oldIngredient.get().getAmount() + ingredient.getAmount());
				return new ResponseEntity<Ingredient>(ingredientRepository.save(oldIngredient.get()), HttpStatus.OK);
			} else {
				return new ResponseEntity<Ingredient>(ingredientRepository.save(ingredient), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> update(Long id, Ingredient ingredient) {
		try {
			Optional<Ingredient> oldIngredient = ingredientRepository.findById(id);
			if (!oldIngredient.isPresent()) {
				throw new Exception("Invalid ingredient ID");
			} else {
				ingredient.setId(id);
				return new ResponseEntity<Ingredient>(ingredientRepository.save(ingredient), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> destroy(Long id) {
		try {
			Optional<Ingredient> ingredient = ingredientRepository.findById(id);
			if (!ingredient.isPresent()) {
				throw new Exception("Invalid ingredient ID");
			} else {
				ingredientRepository.deleteById(id);
				return new ResponseEntity<Optional<Ingredient>>(ingredient, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
