package com.jumpstart.food_ordering_system.Controller; // Matches your exact project folder hierarchy

// Spring Web framework imports required for the GET mapping
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jumpstart.food_ordering_system.DTO.CategoryDTO;
import com.jumpstart.food_ordering_system.Service.CategoryService;

/**
 * REST Controller that handles incoming HTTP requests for Category data.
 */
@RestController // Marks this class as an API endpoint controller
@RequestMapping("/api/category") // Sets the base URL path for this controller
public class CategoryController {

    // Injecting the service layer dependency to handle business logic
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Handles HTTP GET requests to retrieve all categories.
     * URL: GET http://localhost:8080/api/category
     * 
     * @return A response entity containing the list of Category DTOs and an HTTP 200 OK status.
     */
    @GetMapping // Framework annotation to map this method explicitly to an HTTP GET request
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        // Fetches data processed through the service layer mapping pipeline
        List<CategoryDTO> categories = categoryService.getAllCategories();
        
        // Returns the payload wrapped cleanly in an HTTP response wrapper
        return ResponseEntity.ok(categories);
    }
}
