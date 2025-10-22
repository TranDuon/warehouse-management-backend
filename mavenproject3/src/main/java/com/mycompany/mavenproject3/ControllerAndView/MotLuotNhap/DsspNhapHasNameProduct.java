/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotNhap;

import com.mycompany.mavenproject3.Db.DsspNhap.DsspNhap;

/**
 *
 * @author azoom
 */
public class DsspNhapHasNameProduct {
    private DsspNhap dsspNhap;
    private String ten;

    public DsspNhapHasNameProduct() {
    }

    public DsspNhapHasNameProduct(DsspNhap dsspNhap, String ten) {
        this.dsspNhap = dsspNhap;
        this.ten = ten;
    }

    public DsspNhap getDsspNhap() {
        return dsspNhap;
    }

    public String getTen() {
        return ten;
    }
    
    
}
