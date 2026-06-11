package com.jumpstart.food_ordering_system.Service;

import java.util.List;

import com.jumpstart.food_ordering_system.DTO.CategoryDTO;

/**
 * Service interface defining the business contract for Category operations.
 */
public interface CategoryService {

    /**
     * Retrieves all categories from the system database.
     * @return A list of Category Data Transfer Objects.
     */
    List<CategoryDTO> getAllCategories();
}
