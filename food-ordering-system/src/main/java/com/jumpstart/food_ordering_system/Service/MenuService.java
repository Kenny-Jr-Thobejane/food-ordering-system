package com.jumpstart.food_ordering_system.Service;

import java.util.List;

import com.jumpstart.food_ordering_system.DTO.MenuDTO;

public interface MenuService {
    MenuDTO addMenu(MenuDTO dto);
    List<MenuDTO> getAllMenus();
    MenuDTO getMenuById(Long id);
}