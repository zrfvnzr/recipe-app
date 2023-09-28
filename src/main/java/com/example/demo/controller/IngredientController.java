package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Ingredient;
import com.example.demo.service.IngredientService;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping("")
	public ResponseEntity<?> index() {
		return this.ingredientService.index();
	}
	
	@PostMapping("")
	public ResponseEntity<?> store(Ingredient ingredient) {
		return this.ingredientService.store(ingredient);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value="id") Long id, Ingredient ingredient) {
		return this.ingredientService.update(id, ingredient);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> destroy(@PathVariable(value="id") Long id) {
		return this.ingredientService.destroy(id);
	}
	
}
