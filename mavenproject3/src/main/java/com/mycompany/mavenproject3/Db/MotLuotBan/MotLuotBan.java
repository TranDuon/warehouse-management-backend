/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.MotLuotBan;

import java.sql.Timestamp;


/**
 *
 * @author azoom
 */
public class MotLuotBan {
    private Long id;
    private Timestamp thoigian;
    private Boolean dathanhtoan;
    private Long UseridNhanvien;
    public MotLuotBan() {
    }
    public MotLuotBan(Long id, Timestamp thoigian, Boolean dathanhtoan, Long useridNhanvien) {
        this.id = id;
        this.thoigian = thoigian;
        this.dathanhtoan = dathanhtoan;
        UseridNhanvien = useridNhanvien;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getThoigian() {
        return thoigian;
    }

    public void setThoigian(Timestamp thoigian) {
        this.thoigian = thoigian;
    }

    public Boolean getDathanhtoan() {
        return dathanhtoan;
    }

    public void setDathanhtoan(Boolean dathanhtoan) {
        this.dathanhtoan = dathanhtoan;
    }

    public Long getUseridNhanvien() {
        return UseridNhanvien;
    }

    public void setUseridNhanvien(Long UseridNhanvien) {
        this.UseridNhanvien = UseridNhanvien;
    }

    @Override
    public String toString() {
        return "MotLuotBan{" + "id=" + id + ", thoigian=" + thoigian + ", dathanhtoan=" + dathanhtoan + ", UseridNhanvien=" + UseridNhanvien + '}';
    }
    
    
}
