package com.jumpstart.food_ordering_system.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Marks this class as a database table mapping.
@Entity
// Specifies the exact database table name.
@Table(name = "category")
public class CategoryEntity {

    // Defines the primary key column.
    @Id
    // Configures automatic primary key generation using auto-increment.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Defines a basic database string column.
    private String name;

    // Standard no-argument constructor required by JPA.
    public CategoryEntity() {
    }

    // Getters and Setters (Required for data access)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
