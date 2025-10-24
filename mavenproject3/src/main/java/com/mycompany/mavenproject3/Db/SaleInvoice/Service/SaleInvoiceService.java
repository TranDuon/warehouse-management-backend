/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleInvoice.Service;

import com.mycompany.mavenproject3.Db.SaleInvoice.Repository.SaleInvoiceRepo;
import com.mycompany.mavenproject3.Db.SaleInvoice.Entity.SaleInvoice;
import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;

/**
 *
 * @author azoom
 */
public class SaleInvoiceService 
        implements ServiceInterface<SaleInvoice, Long>
{
    private SaleInvoiceRepo hoaDonBanRepo;

    public SaleInvoiceService() {
        this.hoaDonBanRepo = new SaleInvoiceRepo();
    }

    
    @Override
    public SaleInvoice findById(Long id) {
        return this.hoaDonBanRepo.findById(id);
    }

    @Override
    public List<SaleInvoice> getList(Integer sttPage, Integer sizePage) {
        return this.hoaDonBanRepo.getList(sttPage, sizePage);
    }
    @Override

    public SaleInvoice create(SaleInvoice t) {
        return this.hoaDonBanRepo.create(t);
    }

    @Override
    public SaleInvoice update(Long id, SaleInvoice t) {
        return this.hoaDonBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.hoaDonBanRepo.delete(id);
    }
}
