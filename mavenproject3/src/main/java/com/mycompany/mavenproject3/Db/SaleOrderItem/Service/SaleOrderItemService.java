/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleOrderItem.Service;

import com.mycompany.mavenproject3.Db.SaleOrderItem.Repository.SaleOrderItemRepo;
import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItemId;
import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItem;
import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;

/**
 *
 * @author azoom
 */
public class SaleOrderItemService 
        implements ServiceInterface<SaleOrderItem, SaleOrderItemId>
{
    private SaleOrderItemRepo dsspBanRepo;

    public SaleOrderItemService() {
        this.dsspBanRepo = new SaleOrderItemRepo();
    }
    
    

    @Override
    public SaleOrderItem findById(SaleOrderItemId id) {
        return this.dsspBanRepo.findById(id);
    }

    @Override
    public List<SaleOrderItem> getList(Integer sttPage, Integer sizePage) {
        return this.dsspBanRepo.getList(sttPage, sizePage);
    }

    @Override
    public SaleOrderItem create(SaleOrderItem t) {
        return this.dsspBanRepo.create(t);
    }
    
    @Override
    public SaleOrderItem update(SaleOrderItemId id, SaleOrderItem t) {
        t.setId(id);
        return this.dsspBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(SaleOrderItemId id) {
        return this.dsspBanRepo.delete(id);
    }
    
    public List<SaleOrderItem> findBySaleTransactionId(Long motLuotBanId){
        return this.dsspBanRepo.findBySaleTransactionId(motLuotBanId);
    }
}
