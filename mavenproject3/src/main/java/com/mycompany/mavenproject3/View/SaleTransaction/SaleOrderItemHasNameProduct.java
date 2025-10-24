/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.View.SaleTransaction;

import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItem;

/**
 *
 * @author azoom
 */
public class SaleOrderItemHasNameProduct {
    private SaleOrderItem saleOrderItem;
    private String name;

    public SaleOrderItemHasNameProduct(SaleOrderItem saleOrderItem, String name) {
        this.saleOrderItem = saleOrderItem;
        this.name = name;
    }

    public SaleOrderItem getSaleOrderItem() {
        return saleOrderItem;
    }

    public String getName() {
        return name;
    }
    
    
}
