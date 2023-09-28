package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Recipe;
import com.example.demo.service.RecipeService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("")
	public ResponseEntity<?> index() {
		return this.recipeService.index();
	}
	
	@PostMapping("")
	public ResponseEntity<?> store(@RequestBody Recipe recipe) {
		return this.recipeService.store(recipe);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value="id") Long id, @RequestBody Recipe recipe) {
		return this.recipeService.update(id, recipe);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> destroy(@PathVariable(value="id") Long id) {
		return this.recipeService.destroy(id);
	}
}
