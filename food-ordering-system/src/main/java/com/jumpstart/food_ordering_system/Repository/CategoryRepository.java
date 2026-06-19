package com.jumpstart.food_ordering_system.Repository;

// Import your custom database entity class instead of java.util.Locale
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumpstart.food_ordering_system.Entity.CategoryEntity;

/**
 * Repository interface for managing Category_Entity persistence operations.
 * By extending JpaRepository, Spring Data automatically provides standard CRUD methods.
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    // JpaRepository implicitly includes methods like save(), findById(), findAll(), and deleteById().
}
