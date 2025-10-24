/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity;

/**
 *
 * @author azoom
 */
public class PurschaseOrderItem {
    private PurschaseOrderItemId id;
    private Integer quantity;
    private Long price;

    public PurschaseOrderItem() {
    }

    public PurschaseOrderItem(PurschaseOrderItemId id, Integer quantity, Long price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public PurschaseOrderItemId getId() {
        return id;
    }

    public void setId(PurschaseOrderItemId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    
    
}
