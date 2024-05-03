package com.example.spring_cognito.controller;

import com.example.spring_cognito.model.Recipe;
import com.example.spring_cognito.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes"; // Assuming you have a recipes.html Thymeleaf template
    }

    @GetMapping("/{id}")
    public String getRecipeById(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "recipe"; // Assuming you have a recipe.html Thymeleaf template
    }

    @PostMapping
    public String addRecipe(@ModelAttribute Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/recipes";
    }

    @PutMapping("/{id}")
    public String updateRecipe(@PathVariable Long id, @ModelAttribute Recipe recipe) {
        recipeService.updateRecipe(id, recipe);
        return "redirect:/recipes";
    }

    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return "redirect:/recipes";
    }
}
