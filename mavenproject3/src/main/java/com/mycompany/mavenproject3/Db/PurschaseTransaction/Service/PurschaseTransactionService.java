/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.MotLuotNhap;

import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;
import com.mycompany.mavenproject3.Db.MotLuotBan.MotLuotBan;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author azoom
 */
public class MotLuotNhapService 
        implements ServiceInterface<MotLuotNhap, Long>
{
    private MotLuotNhapRepo motLuotNhapRepo;

    public MotLuotNhapService() {
        this.motLuotNhapRepo = new MotLuotNhapRepo();
    }

    @Override
    public MotLuotNhap findById(Long id) {
        return this.motLuotNhapRepo.findById(id);
    }

    @Override
    public List<MotLuotNhap> getList(Integer sttPage, Integer sizePage) {
        return this.motLuotNhapRepo.getList(sttPage, sizePage);
    }

    @Override
    public MotLuotNhap create(MotLuotNhap t) {
        return this.motLuotNhapRepo.create(t);
    }

    @Override
    public MotLuotNhap update(Long id, MotLuotNhap t) {
        return this.motLuotNhapRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.motLuotNhapRepo.delete(id);
    }

    public List<MotLuotNhap> findByTime(Timestamp from, Timestamp to){
        return this.motLuotNhapRepo.findByTime(from, to);
    }    
}
