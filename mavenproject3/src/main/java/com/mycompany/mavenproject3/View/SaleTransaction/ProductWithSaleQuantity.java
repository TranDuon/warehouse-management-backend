/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.View.SaleTransaction;

import com.mycompany.mavenproject3.Db.Product.Entity.Product;

/**
 *
 * @author azoom
 */
public class ProductWithSaleQuantity {
    private Product product;
    private Integer quantity;

    public ProductWithSaleQuantity(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "VatPhamWithSoLuongDat{" + "vatPham=" + product.toString() + ", soLuongDat=" + quantity + '}';
    }
    
    
}
