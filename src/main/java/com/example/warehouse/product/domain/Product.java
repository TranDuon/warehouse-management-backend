package com.example.warehouse.product.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String sku;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 32)
    private String unit;

    @Column(nullable = false)
    private Integer minStock = 0;

    @Column(length = 500)
    private String description;
}
