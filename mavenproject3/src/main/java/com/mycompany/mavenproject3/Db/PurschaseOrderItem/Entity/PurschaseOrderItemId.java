/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity;

/**
 *
 * @author azoom
 */
public class PurschaseOrderItemId {
    private Long Productid;
    private Long PurschaseTransactionid;

    public PurschaseOrderItemId() {
    }

    public PurschaseOrderItemId(Long VatPhamid, Long MotLuotBanid) {
        this.Productid = VatPhamid;
        this.PurschaseTransactionid = MotLuotBanid;
    }

    public Long getProductid() {
        return Productid;
    }

    public void setProductid(Long Productid) {
        this.Productid = Productid;
    }

    public Long getPurschaseTransactionid() {
        return PurschaseTransactionid;
    }

    public void setPurschaseTransactionid(Long PurschaseTransactionid) {
        this.PurschaseTransactionid = PurschaseTransactionid;
    }

    @Override
    public String toString() {
        return "DsspNhapId{" + "VatPhamid=" + Productid + ", MotLuotBanid=" + PurschaseTransactionid + '}';
    }
    
    
}
