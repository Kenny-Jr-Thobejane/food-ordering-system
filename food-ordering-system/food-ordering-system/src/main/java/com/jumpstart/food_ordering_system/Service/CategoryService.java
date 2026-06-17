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

    /**
     * Retrieves a single category by its unique identifier.
     * @param id The ID of the category to find.
     * @return The Category Data Transfer Object.
     */
    CategoryDTO getCategoryById(Long id);

    /**
     * Creates a new category in the system database.
     * @param dto The data transfer object containing new category details.
     * @return The saved Category Data Transfer Object.
     */
    CategoryDTO addCategory(CategoryDTO dto);

    /**
 * Updates an existing category by its ID.
 * @param id The ID of the category to update.
 * @param dto The data transfer object containing updated details.
 * @return The updated Category Data Transfer Object.
 */
CategoryDTO updateCategory(Long id, CategoryDTO dto);

/**
 * Deletes a category from the database by its ID.
 * @param id The ID of the category to remove.
 */
void deleteCategory(Long id);

}
