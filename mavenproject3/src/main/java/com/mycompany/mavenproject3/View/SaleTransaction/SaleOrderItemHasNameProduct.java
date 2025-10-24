/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotBan;

import com.mycompany.mavenproject3.Db.DsspBan.DsspBan;

/**
 *
 * @author azoom
 */
public class DsspBanHasNameProduct {
    private DsspBan dsspBan;
    private String ten;

    public DsspBanHasNameProduct(DsspBan dsspBan, String ten) {
        this.dsspBan = dsspBan;
        this.ten = ten;
    }

    public DsspBan getDsspBan() {
        return dsspBan;
    }

    public String getTen() {
        return ten;
    }
    
    
}
