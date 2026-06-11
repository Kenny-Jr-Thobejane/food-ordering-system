package com.jumpstart.food_ordering_system.DTO;

/**
 * Data Transfer Object (DTO) for Category data.
 * Used to transfer data between process layers without exposing core Entity logic.
 */
public class CategoryDTO {

    // Unique identification token for mapping the category.
    private Long id;

    // Display name descriptive label of the category.
    private String name;

    // Default constructor for framework initialization and serialization.
    public CategoryDTO() {
    }

    // Retrieves the current category identification value.
    public Long getId() {
        return id;
    }

    // Updates or assigns the category identification value.
    public void setId(Long id) {
        this.id = id;
    }

    // Retrieves the current string label of the category.
    public String getName() {
        return name;
    }

    // Updates or assigns the string label of the category.
    public void setName(String name) {
        this.name = name;
    }
}
