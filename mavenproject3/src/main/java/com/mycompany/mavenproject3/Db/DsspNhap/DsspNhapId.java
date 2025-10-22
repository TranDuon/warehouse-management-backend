/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.DsspNhap;

/**
 *
 * @author azoom
 */
public class DsspNhapId {
    private Long VatPhamid;
    private Long MotLuotNhapid;

    public DsspNhapId() {
    }

    public DsspNhapId(Long VatPhamid, Long MotLuotBanid) {
        this.VatPhamid = VatPhamid;
        this.MotLuotNhapid = MotLuotBanid;
    }

    public Long getVatPhamid() {
        return VatPhamid;
    }

    public void setVatPhamid(Long VatPhamid) {
        this.VatPhamid = VatPhamid;
    }

    public Long getMotLuotNhapid() {
        return MotLuotNhapid;
    }

    public void setMotLuotNhapid(Long MotLuotNhapid) {
        this.MotLuotNhapid = MotLuotNhapid;
    }

    @Override
    public String toString() {
        return "DsspNhapId{" + "VatPhamid=" + VatPhamid + ", MotLuotBanid=" + MotLuotNhapid + '}';
    }
    
    
}
