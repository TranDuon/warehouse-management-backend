/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.DsspNhap;

import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;
import java.util.List;

/**
 *
 * @author azoom
 */
public class DsspNhapService 
        implements ServiceInterface<DsspNhap, DsspNhapId>
{
    private DsspNhapRepo dsspNhapRepo;

    public DsspNhapService() {
        this.dsspNhapRepo = new DsspNhapRepo();
    }

    @Override
    public DsspNhap findById(DsspNhapId id) {
        return this.dsspNhapRepo.findById(id);
    }

    @Override
    public List<DsspNhap> getList(Integer sttPage, Integer sizePage) {
        return this.dsspNhapRepo.getList(sttPage, sizePage);
    }

    @Override
    public DsspNhap create(DsspNhap t) {
        return this.dsspNhapRepo.create(t);
    }

    @Override
    public DsspNhap update(DsspNhapId id, DsspNhap t) {
        return this.dsspNhapRepo.update(id, t);
    }

    @Override
    public Boolean delete(DsspNhapId id) {
        return this.dsspNhapRepo.delete(id);
    }
    
    public List<DsspNhap> findByMotLuotNhapId(Long motLuotNhapId){
        return this.dsspNhapRepo.findByMotLuotNhapId(motLuotNhapId);
    }
    
}
