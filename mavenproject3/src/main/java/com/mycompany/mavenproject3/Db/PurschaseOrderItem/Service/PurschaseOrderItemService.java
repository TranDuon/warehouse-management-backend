/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.PurschaseOrderItem.Service;

import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Repository.PurschaseOrderItemRepo;
import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity.PurschaseOrderItem;
import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity.PurschaseOrderItemId;
import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;
import java.util.List;

/**
 *
 * @author azoom
 */
public class PurschaseOrderItemService 
        implements ServiceInterface<PurschaseOrderItem, PurschaseOrderItemId>
{
    private PurschaseOrderItemRepo dsspNhapRepo;

    public PurschaseOrderItemService() {
        this.dsspNhapRepo = new PurschaseOrderItemRepo();
    }

    @Override
    public PurschaseOrderItem findById(PurschaseOrderItemId id) {
        return this.dsspNhapRepo.findById(id);
    }

    @Override
    public List<PurschaseOrderItem> getList(Integer sttPage, Integer sizePage) {
        return this.dsspNhapRepo.getList(sttPage, sizePage);
    }

    @Override
    public PurschaseOrderItem create(PurschaseOrderItem t) {
        return this.dsspNhapRepo.create(t);
    }

    @Override
    public PurschaseOrderItem update(PurschaseOrderItemId id, PurschaseOrderItem t) {
        return this.dsspNhapRepo.update(id, t);
    }

    @Override
    public Boolean delete(PurschaseOrderItemId id) {
        return this.dsspNhapRepo.delete(id);
    }
    
    public List<PurschaseOrderItem> findByMotLuotNhapId(Long motLuotNhapId){
        return this.dsspNhapRepo.findByPurschaseTransactionId(motLuotNhapId);
    }
    
}
