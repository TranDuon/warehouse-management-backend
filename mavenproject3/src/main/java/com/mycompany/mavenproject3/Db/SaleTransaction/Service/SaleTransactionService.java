/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.MotLuotBan;

import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;
import java.sql.Timestamp;

/**
 *
 * @author azoom
 */
public class MotLuotBanService 
        implements ServiceInterface<MotLuotBan, Long>
{
    private MotLuotBanRepo motLuotBanRepo;

    public MotLuotBanService() {
        this.motLuotBanRepo = new MotLuotBanRepo();
    }
    
    

    @Override
    public MotLuotBan findById(Long id) {
        return this.motLuotBanRepo.findById(id);
    }

    @Override
    public List<MotLuotBan> getList(Integer sttPage, Integer sizePage) {
        return this.motLuotBanRepo.getList(sttPage, sizePage);
    }
    
    @Override
    public MotLuotBan create(MotLuotBan t) {
        return this.motLuotBanRepo.create(t);
    }

    @Override
    public MotLuotBan update(Long id, MotLuotBan t) {
        return this.motLuotBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.motLuotBanRepo.delete(id);
    }
    
    public List<MotLuotBan> findByTime(Timestamp from, Timestamp to){
        return this.motLuotBanRepo.findByTime(from, to);
    }
}
