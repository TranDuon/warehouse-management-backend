/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleOrderItem.Entity;


/**
 *
 * @author azoom
 */

public class SaleOrderItem {

    private SaleOrderItemId id;
    private Integer quantity;
    private Long price;

    public SaleOrderItem() {
    }
    
    public SaleOrderItem(SaleOrderItemId id, Integer quantity, Long price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public SaleOrderItemId getId() {
        return id;
    }

    public void setId(SaleOrderItemId id) {
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