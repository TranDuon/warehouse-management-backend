/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotNhap;

import com.mycompany.mavenproject3.ControllerAndView.MotLuotBan.*;
import com.mycompany.mavenproject3.Db.VatPham.VatPham;

/**
 *
 * @author azoom
 */
public class VatPhamWithSoLuongNhap {
    private VatPham vatPham;
    private Integer soLuongNhap;

    public VatPhamWithSoLuongNhap(VatPham vatPham, Integer soLuong) {
        this.vatPham = vatPham;
        this.soLuongNhap = soLuong;
    }

    public VatPham getVatPham() {
        return vatPham;
    }

    public Integer getSoLuongNhap() {
        return soLuongNhap;
    }

    @Override
    public String toString() {
        return "VatPhamWithSoLuongDat{" + "vatPham=" + vatPham.toString() + ", soLuongDat=" + soLuongNhap + '}';
    }
    
    
}
