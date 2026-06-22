package com.jumpstart.food_ordering_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jumpstart.food_ordering_system.DTO.CategoryDTO;
import com.jumpstart.food_ordering_system.Service.CategoryService;

/**
 * REST Controller providing full CRUD endpoints for Category data management.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * POST /api/categories
     * Creates a new product category.
     * 
     * @param categoryDTO Validated data transfer object payload.
     * @return The created CategoryDTO with an HTTP 21 Created status.
     */
    @PostMapping
public ResponseEntity<CategoryDTO> createCategory(@Validated @RequestBody CategoryDTO categoryDTO) {
    // Highlighted Fix: Changed createCategory to addCategory
    CategoryDTO createdCategory = categoryService.addCategory(categoryDTO); 
    return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
}


    /**
     * GET /api/categories
     * Lists all existing categories.
     * 
     * @return List of all categories wrapped in HTTP 200 OK.
     */
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    /**
     * GET /api/categories/{id}
     * Retrieves a single category profile by its unique ID.
     * 
     * @param id Unique identifier integer.
     * @return Found category entity wrapped in HTTP 200 OK.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    /**
     * PUT /api/categories/{id}
     * Modifies properties of an existing category by its ID.
     * 
     * @param id Unique identifier integer target.
     * @param categoryDTO Validated request payload containing update values.
     * @return Updated CategoryDTO token wrapped in HTTP 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable Long id, 
            @Validated @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    /**
     * DELETE /api/categories/{id}
     * Removes a category profile entry from the system.
     * 
     * @param id Unique identifier integer targeting deletion record.
     * @return Empty response context displaying HTTP 204 No Content success flag.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
