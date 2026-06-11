package com.jumpstart.food_ordering_system.Service;

// Import your custom DTO, Entity, and Repository layers
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumpstart.food_ordering_system.DTO.CategoryDTO;
import com.jumpstart.food_ordering_system.Entity.CategoryEntity;
import com.jumpstart.food_ordering_system.Repository.CategoryRepository;

/**
 * Service implementation responsible for handling Category business logic,
 * bridging the gap between database entities and data transfer objects.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    // RESPONSIBILITY 1: Inject CategoryRepository
    // A final private field ensures the dependency cannot be altered after initialization.
    private final CategoryRepository categoryRepository;

    // Use constructor injection to cleanly supply the repository component.
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Executes the process of retrieving data, mapping it, and returning the result.
     */
    @Override
    public List<CategoryDTO> getAllCategories() {
        
        // RESPONSIBILITY 2: Retrieve categories from the database
        // Calls the JpaRepository built-in findAll() method to fetch all database records.
        List<CategoryEntity> categories = categoryRepository.findAll();

        // RESPONSIBILITY 3 & 4: Convert Category entities into CategoryDto objects & Return a list
        // Streams through the collection, maps each entity via a helper method, and packages them into a list.
        return categories.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Helper method to map fields from Category_Entity to Category_DTO.
     * This isolates mapping logic and prevents data model exposure.
     */
    private CategoryDTO convertToDto(CategoryEntity categoryEntity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(categoryEntity.getId());
        dto.setName(categoryEntity.getName());
        return dto;
    }
}
