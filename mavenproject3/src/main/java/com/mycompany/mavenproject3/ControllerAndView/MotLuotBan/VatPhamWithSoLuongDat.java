/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotBan;

import com.mycompany.mavenproject3.Db.VatPham.VatPham;

/**
 *
 * @author azoom
 */
public class VatPhamWithSoLuongDat {
    private VatPham vatPham;
    private Integer soLuongDat;

    public VatPhamWithSoLuongDat(VatPham vatPham, Integer soLuong) {
        this.vatPham = vatPham;
        this.soLuongDat = soLuong;
    }

    public VatPham getVatPham() {
        return vatPham;
    }

    public Integer getSoLuongDat() {
        return soLuongDat;
    }

    @Override
    public String toString() {
        return "VatPhamWithSoLuongDat{" + "vatPham=" + vatPham.toString() + ", soLuongDat=" + soLuongDat + '}';
    }
    
    
}
