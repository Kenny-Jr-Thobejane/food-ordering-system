package com.jumpstart.food_ordering_system.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jumpstart.food_ordering_system.DTO.MenuDTO;
import com.jumpstart.food_ordering_system.Entity.CategoryEntity;
import com.jumpstart.food_ordering_system.Entity.MenuEntity;
import com.jumpstart.food_ordering_system.Exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.Exception.MenuNotFoundException;
import com.jumpstart.food_ordering_system.Repository.CategoryRepository;
import com.jumpstart.food_ordering_system.Repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public MenuDTO addMenu(MenuDTO dto) {
        CategoryEntity category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(
                        "Category not found with id: " + dto.getCategoryId()));

        MenuEntity menu = convertToEntity(dto, category);
        MenuEntity saved = menuRepository.save(menu);
        return convertToDto(saved);
    }

    @Override
    public List<MenuDTO> getAllMenus() {
        return menuRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MenuDTO getMenuById(Long id) {
        MenuEntity menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found with id: " + id));
        return convertToDto(menu);
    }

    private MenuDTO convertToDto(MenuEntity menu) {
        return MenuDTO.builder()
                .id(menu.getId())
                .name(menu.getName())
                .description(menu.getDescription())
                .price(menu.getPrice())
                .imageUrl(menu.getImageUrl())
                .categoryId(menu.getCategory().getId())
                .categoryName(menu.getCategory().getName())
                .build();
    }

    private MenuEntity convertToEntity(MenuDTO dto, CategoryEntity category) {
        return MenuEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .category(category)
                .build();
    }
}