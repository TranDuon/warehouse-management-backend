/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.View.PurschaseTransaction;

import com.mycompany.mavenproject3.Db.Product.Entity.Product;

/**
 *
 * @author azoom
 */
public class ProductWithPurschaseQuantity {
    private Product vatPham;
    private Integer soLuongNhap;

    public ProductWithPurschaseQuantity(Product vatPham, Integer soLuong) {
        this.vatPham = vatPham;
        this.soLuongNhap = soLuong;
    }

    public Product getVatPham() {
        return vatPham;
    }

    public Integer getSoLuongNhap() {
        return soLuongNhap;
    }

    @Override
    public String toString() {
        return "VatPhamWithSoLuongDat{" + "vatPham=" + vatPham.toString() + ", soLuongDat=" + soLuongNhap + '}';
    }
    
    
}
