/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.HoaDonBan;

import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;

/**
 *
 * @author azoom
 */
public class HoaDonBanService 
        implements ServiceInterface<HoaDonBan, Long>
{
    private HoaDonBanRepo hoaDonBanRepo;

    public HoaDonBanService() {
        this.hoaDonBanRepo = new HoaDonBanRepo();
    }

    
    @Override
    public HoaDonBan findById(Long id) {
        return this.hoaDonBanRepo.findById(id);
    }

    @Override
    public List<HoaDonBan> getList(Integer sttPage, Integer sizePage) {
        return this.hoaDonBanRepo.getList(sttPage, sizePage);
    }
    @Override

    public HoaDonBan create(HoaDonBan t) {
        return this.hoaDonBanRepo.create(t);
    }

    @Override
    public HoaDonBan update(Long id, HoaDonBan t) {
        return this.hoaDonBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.hoaDonBanRepo.delete(id);
    }
}
