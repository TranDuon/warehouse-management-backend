/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.DsspBan;


/**
 *
 * @author azoom
 */
public class DsspBanId {
    private Long VatPhamid;
    private Long MotLuotBanid;

    public DsspBanId() {
    }
    
    public DsspBanId(Long vatPhamid, Long motLuotBanid) {
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
