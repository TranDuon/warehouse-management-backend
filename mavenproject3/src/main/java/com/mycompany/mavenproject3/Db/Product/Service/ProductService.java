/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.VatPham;

import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;

/**
 *
 * @author azoom
 */
public class VatPhamService 
        implements ServiceInterface<VatPham, Long>
{
    private VatPhamRepo vatPhamRepo;

    public VatPhamService() {
        this.vatPhamRepo = new VatPhamRepo();
    }
    
    

    @Override
    public VatPham findById(Long id) {
        return this.vatPhamRepo.findById(id);
    }

    @Override
    public List<VatPham> getList(Integer sttPage, Integer sizePage) {
        return this.vatPhamRepo.getList(sttPage, sizePage);
    }
    @Override

    public VatPham create(VatPham t) {
        return this.vatPhamRepo.create(t);
    }

    @Override
    public VatPham update(Long id, VatPham t) {
        return this.vatPhamRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.vatPhamRepo.delete(id);
    }
    
    public List<VatPham> findByName(String name){
        return this.vatPhamRepo.findByName(name);
    }
    
    
}
