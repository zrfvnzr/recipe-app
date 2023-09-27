package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Recipe;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

	@GetMapping("/")
	public Recipe[] index() {
		return null;
	}
	
	@PostMapping("/")
	public Recipe store(@RequestBody Recipe recipe) {
		return null;
	}
	
	@PutMapping("/{id}")
	public Recipe update(@PathVariable(value="id") Long id, @RequestBody Recipe recipe) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	public Recipe destroy(@PathVariable(value="id") Long id) {
		return null;
	}
}
