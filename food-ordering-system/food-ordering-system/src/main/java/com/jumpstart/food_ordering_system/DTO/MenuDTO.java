package com.jumpstart.food_ordering_system.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {

    private Long id;

    @NotBlank(message = "Menu name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", message = "Price cannot be negative")
    private BigDecimal price;

    private String imageUrl;

    @NotNull(message = "categoryId is required")
    private Long categoryId;

    private String categoryName;
}