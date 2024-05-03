package com.example.spring_cognito.repository;

import com.example.spring_cognito.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // You can define additional query methods here if needed
}
