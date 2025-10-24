/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleTransaction.Service;

import com.mycompany.mavenproject3.Db.SaleTransaction.Repository.SaleTransactionRepo;
import com.mycompany.mavenproject3.Db.SaleTransaction.Entity.SaleTransaction;
import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;
import java.sql.Timestamp;

/**
 *
 * @author azoom
 */
public class SaleTransactionService 
        implements ServiceInterface<SaleTransaction, Long>
{
    private SaleTransactionRepo motLuotBanRepo;

    public SaleTransactionService() {
        this.motLuotBanRepo = new SaleTransactionRepo();
    }
    
    

    @Override
    public SaleTransaction findById(Long id) {
        return this.motLuotBanRepo.findById(id);
    }

    @Override
    public List<SaleTransaction> getList(Integer sttPage, Integer sizePage) {
        return this.motLuotBanRepo.getList(sttPage, sizePage);
    }
    
    @Override
    public SaleTransaction create(SaleTransaction t) {
        return this.motLuotBanRepo.create(t);
    }

    @Override
    public SaleTransaction update(Long id, SaleTransaction t) {
        return this.motLuotBanRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.motLuotBanRepo.delete(id);
    }
    
    public List<SaleTransaction> findByTime(Timestamp from, Timestamp to){
        return this.motLuotBanRepo.findByTime(from, to);
    }
}
