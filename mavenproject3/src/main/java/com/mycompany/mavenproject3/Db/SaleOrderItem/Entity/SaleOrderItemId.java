/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleOrderItem.Entity;


/**
 *
 * @author azoom
 */
public class SaleOrderItemId {
    private Long VatPhamid;
    private Long MotLuotBanid;

    public SaleOrderItemId() {
    }
    
    public SaleOrderItemId(Long vatPhamid, Long motLuotBanid) {
        VatPhamid = vatPhamid;
        MotLuotBanid = motLuotBanid;
    }

    public Long getVatPhamid() {
        return VatPhamid;
    }

    public void setVatPhamid(Long VatPhamid) {
        this.VatPhamid = VatPhamid;
    }

    public Long getMotLuotBanid() {
        return MotLuotBanid;
    }

    public void setMotLuotBanid(Long MotLuotBanid) {
        this.MotLuotBanid = MotLuotBanid;
    }

}
