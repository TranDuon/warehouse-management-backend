/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.Product.Entity;


/**
 *
 * @author azoom
 */
public class Product {
    
    private Long id;
    private String name;
    private Long price;
    private String unit;
    private String description;
//    private String urlanh;
    private Integer quantity;
    
    public Product() {
    }
    public Product(Long id, String name, Long price, String unit, String description, /* String urlanh, */ Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.description = description;
//        this.urlanh = urlanh;
        this.quantity = quantity;
    }

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getUrlanh() {
//        return urlanh;
//    }
//
//    public void setUrlanh(String urlanh) {
//        this.urlanh = urlanh;
//    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "VatPham{" + "id=" + id + ", ten=" + name + ", gia=" + price + ", donvi=" + unit + ", mota=" + description + ", soluong=" + quantity + '}';
    }
    
    
    
    
    
}
