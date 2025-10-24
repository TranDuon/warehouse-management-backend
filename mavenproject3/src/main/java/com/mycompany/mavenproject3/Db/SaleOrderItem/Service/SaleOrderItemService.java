/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.DsspBan;

import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;

/**
 *
 * @author azoom
 */
public class DsspBanService 
        implements ServiceInterface<DsspBan, DsspBanId>
{
    private DsspBanRepo dsspBanRepo;

    public DsspBanService() {
        this.dsspBanRepo = new DsspBanRepo();
    }
    
    

    @Override
    public DsspBan findById(DsspBanId id) {
        return this.dsspBanRepo.findById(id);
    }

    @Override
    public List<DsspBan> getList(Integer sttPage, Integer sizePage) {
        return this.dsspBanRepo.getList(sttPage, sizePage);
    }

    @Override
    public DsspBan create(DsspBan t) {
        return this.dsspBanRepo.create(t);
    }
    
    @Override
    public DsspBan update(DsspBanId id, DsspBan t) {
        t.setId(id);
        return this.dsspBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(DsspBanId id) {
        return this.dsspBanRepo.delete(id);
    }
    
    public List<DsspBan> findByMotLuotBanId(Long motLuotBanId){
        return this.dsspBanRepo.findByMotLuotBanId(motLuotBanId);
    }
}
