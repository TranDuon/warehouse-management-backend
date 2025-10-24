/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.View.PurschaseTransaction;

import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity.PurschaseOrderItem;

/**
 *
 * @author azoom
 */
public class PurschaseOrderItemHasNameProduct {
    private PurschaseOrderItem purschaseOrderItem;
    private String name;

    public PurschaseOrderItemHasNameProduct() {
    }

    public PurschaseOrderItemHasNameProduct(PurschaseOrderItem dsspNhap, String ten) {
        this.purschaseOrderItem = dsspNhap;
        this.name = ten;
    }

    public PurschaseOrderItem getPurschaseOrderItem() {
        return purschaseOrderItem;
    }

    public String getName() {
        return name;
    }
    
    
}
