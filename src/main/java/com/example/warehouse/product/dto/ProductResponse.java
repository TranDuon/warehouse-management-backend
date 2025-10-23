package com.example.warehouse.product.dto;

public record ProductResponse(
        Long id, String sku, String name, String unit, Integer minStock, String description
) {}
