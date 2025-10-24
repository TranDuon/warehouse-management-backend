/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.MotLuotNhap;

import java.sql.Timestamp;

/**
 *
 * @author azoom
 */
public class MotLuotNhap {
    private Long id;
    private Timestamp thoigian;
    private Boolean dathanhtoan;
    private Long UseridNhanvien;

    public MotLuotNhap() {
    }

    public MotLuotNhap(Long id, Timestamp thoigian, Boolean dathanhtoan, Long UseridNhanVien) {
        this.id = id;
        this.thoigian = thoigian;
        this.dathanhtoan = dathanhtoan;
        this.UseridNhanvien = UseridNhanVien;
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

    public void setUseridNhanvien(Long UseridNhanVien) {
        this.UseridNhanvien = UseridNhanVien;
    }

    @Override
    public String toString() {
        return "MotLuotNhap{" + "id=" + id + ", thoigian=" + thoigian + ", dathanhtoan=" + dathanhtoan + ", UseridNhanVien=" + UseridNhanvien + '}';
    }
    
}
