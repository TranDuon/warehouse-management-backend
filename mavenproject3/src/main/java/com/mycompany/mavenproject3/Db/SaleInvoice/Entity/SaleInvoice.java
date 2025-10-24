/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleInvoice.Entity;

import java.sql.Timestamp;


/**
 *
 * @author azoom
 */
public class SaleInvoice {
    private Long id;
    private Timestamp timestamp;
    private Long amount;
    private Boolean isCashPayment;
    private Long SaleTransactionId;
    public SaleInvoice() {
    }
    public SaleInvoice(Long id, Timestamp timestamp, Long amount, Boolean isCashPayment, Long SaleTransactionId) {
        this.id = id;
        this.timestamp = timestamp;
        this.amount = amount;
        this.isCashPayment = isCashPayment;
        this.SaleTransactionId = SaleTransactionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Boolean getIsCashPayment() {
        return isCashPayment;
    }

    public void setIsCashPayment(Boolean isCashPayment) {
        this.isCashPayment = isCashPayment;
    }

    public Long getSaleTransactionId() {
        return SaleTransactionId;
    }

    public void setSaleTransactionId(Long SaleTransactionId) {
        this.SaleTransactionId = SaleTransactionId;
    }
    
    
}
