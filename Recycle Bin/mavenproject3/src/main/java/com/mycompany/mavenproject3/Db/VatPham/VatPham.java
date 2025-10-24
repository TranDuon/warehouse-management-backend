/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.VatPham;


/**
 *
 * @author azoom
 */
public class VatPham {
    
    private Long id;
    private String ten;
    private Long gia;
    private String donvi;
    private String mota;
//    private String urlanh;
    private Integer soluong;
    
    public VatPham() {
    }
    public VatPham(Long id, String ten, Long gia, String donvi, String mota, /* String urlanh, */ Integer soluong) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.donvi = donvi;
        this.mota = mota;
//        this.urlanh = urlanh;
        this.soluong = soluong;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

//    public String getUrlanh() {
//        return urlanh;
//    }
//
//    public void setUrlanh(String urlanh) {
//        this.urlanh = urlanh;
//    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "VatPham{" + "id=" + id + ", ten=" + ten + ", gia=" + gia + ", donvi=" + donvi + ", mota=" + mota + ", soluong=" + soluong + '}';
    }
    
    
    
    
    
}
