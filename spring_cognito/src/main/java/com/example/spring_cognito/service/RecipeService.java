package com.example.spring_cognito.service;

import com.example.spring_cognito.model.Recipe;
import com.example.spring_cognito.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        return recipeOptional.orElse(null); // Return the found recipe, or null if not found
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Optional<Recipe> existingRecipeOptional = recipeRepository.findById(id);
        if (existingRecipeOptional.isPresent()) {
            Recipe existingRecipe = existingRecipeOptional.get();
            // Update existing recipe with the fields from updatedRecipe
            // Example:
            existingRecipe.setName(updatedRecipe.getName());
            existingRecipe.setDescription(updatedRecipe.getDescription());
            // Update other fields as needed

            return recipeRepository.save(existingRecipe);
        } else {
            // Handle scenario where recipe with given id is not found
            return null;
        }
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
