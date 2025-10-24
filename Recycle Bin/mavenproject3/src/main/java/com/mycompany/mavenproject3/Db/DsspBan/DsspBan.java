/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.DsspBan;


/**
 *
 * @author azoom
 */

public class DsspBan {

    private DsspBanId id;
    private Integer soluong;
    private Long gia;

    public DsspBan() {
    }
    
    public DsspBan(DsspBanId id, Integer soluong, Long gia) {
        this.id = id;
        this.soluong = soluong;
        this.gia = gia;
    }

    public DsspBanId getId() {
        return id;
    }

    public void setId(DsspBanId id) {
        this.id = id;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    
}