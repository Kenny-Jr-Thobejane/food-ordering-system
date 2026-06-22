package com.jumpstart.food_ordering_system.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jumpstart.food_ordering_system.DTO.CategoryDTO;
import com.jumpstart.food_ordering_system.Entity.CategoryEntity;
import com.jumpstart.food_ordering_system.Exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    // Use constructor injection directly (Clean architecture without redundant @Autowired)
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        return convertToDto(categoryEntity);
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO dto) {
        CategoryEntity categoryEntity = convertToEntity(dto);
        CategoryEntity savedCategory = categoryRepository.save(categoryEntity);
        return convertToDto(savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        
        categoryEntity.setName(dto.getName());
        CategoryEntity updatedCategory = categoryRepository.save(categoryEntity);
        return convertToDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        categoryRepository.delete(categoryEntity);
    }

    // Helper method to map fields from CategoryEntity to CategoryDTO
    private CategoryDTO convertToDto(CategoryEntity categoryEntity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(categoryEntity.getId());
        dto.setName(categoryEntity.getName());
        return dto;
    }

    // Helper method to map fields from CategoryDTO to CategoryEntity
    private CategoryEntity convertToEntity(CategoryDTO dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(dto.getName());
        return categoryEntity;
    }
}
