/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.PurschaseTransaction.Entity;

import java.sql.Timestamp;

/**
 *
 * @author azoom
 */
public class PurschaseTransaction {
    private Long id;
    private Timestamp timestamp;
    private Boolean isPaid;
    private Long UseridEmployee;

    public PurschaseTransaction() {
    }

    public PurschaseTransaction(Long id, Timestamp timestamp, Boolean isPaid, Long UseridEmployee) {
        this.id = id;
        this.timestamp = timestamp;
        this.isPaid = isPaid;
        this.UseridEmployee = UseridEmployee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Long getUseridEmployee() {
        return UseridEmployee;
    }

    public void setUseridEmployee(Long UseridNhanVien) {
        this.UseridEmployee = UseridNhanVien;
    }

    @Override
    public String toString() {
        return "MotLuotNhap{" + "id=" + id + ", thoigian=" + timestamp + ", dathanhtoan=" + isPaid + ", UseridNhanVien=" + UseridEmployee + '}';
    }
    
}
