/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.HoaDonBan;

import java.sql.Timestamp;


/**
 *
 * @author azoom
 */
public class HoaDonBan {
    private Long id;
    private Timestamp thoigian;
    private Long sotien;
    private Boolean lathanhtoantienmat;
    private Long Motluotbanid;
    public HoaDonBan() {
    }
    public HoaDonBan(Long id, Timestamp thoigian, Long sotien, Boolean lathanhtoantienmat, Long motluotbanid) {
        this.id = id;
        this.thoigian = thoigian;
        this.sotien = sotien;
        this.lathanhtoantienmat = lathanhtoantienmat;
        Motluotbanid = motluotbanid;
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

    public Long getSotien() {
        return sotien;
    }

    public void setSotien(Long sotien) {
        this.sotien = sotien;
    }

    public Boolean getLathanhtoantienmat() {
        return lathanhtoantienmat;
    }

    public void setLathanhtoantienmat(Boolean lathanhtoantienmat) {
        this.lathanhtoantienmat = lathanhtoantienmat;
    }

    public Long getMotluotbanid() {
        return Motluotbanid;
    }

    public void setMotluotbanid(Long Motluotbanid) {
        this.Motluotbanid = Motluotbanid;
    }
    
    
}
