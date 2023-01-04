package com.example.foodplannerproject.repository;


import com.example.foodplannerproject.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    Recipe save(Recipe recipe);

    void deleteById(Long Id);

    Optional<Recipe> findAllById(Long id);

    @Query("SELECT COUNT(r) FROM Recipe r")
    Integer quantityOfAllRecipes();
}
