package com.example.warehouse.product.dto;

import jakarta.validation.constraints.*;

public record ProductRequest(
        @NotBlank @Size(max = 64) String sku,
        @NotBlank String name,
        @NotBlank @Size(max = 32) String unit,
        @NotNull @Min(0) Integer minStock,
        @Size(max = 500) String description
) {}
