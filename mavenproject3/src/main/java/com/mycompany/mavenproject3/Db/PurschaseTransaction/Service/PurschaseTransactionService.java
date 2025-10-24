/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.PurschaseTransaction.Service;

import com.mycompany.mavenproject3.Db.PurschaseTransaction.Repository.PurschaseTransactionRepo;
import com.mycompany.mavenproject3.Db.PurschaseTransaction.Entity.PurschaseTransaction;
import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;
import com.mycompany.mavenproject3.Db.SaleTransaction.Entity.SaleTransaction;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author azoom
 */
public class PurschaseTransactionService 
        implements ServiceInterface<PurschaseTransaction, Long>
{
    private PurschaseTransactionRepo motLuotNhapRepo;

    public PurschaseTransactionService() {
        this.motLuotNhapRepo = new PurschaseTransactionRepo();
    }

    @Override
    public PurschaseTransaction findById(Long id) {
        return this.motLuotNhapRepo.findById(id);
    }

    @Override
    public List<PurschaseTransaction> getList(Integer sttPage, Integer sizePage) {
        return this.motLuotNhapRepo.getList(sttPage, sizePage);
    }

    @Override
    public PurschaseTransaction create(PurschaseTransaction t) {
        return this.motLuotNhapRepo.create(t);
    }

    @Override
    public PurschaseTransaction update(Long id, PurschaseTransaction t) {
        return this.motLuotNhapRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.motLuotNhapRepo.delete(id);
    }

    public List<PurschaseTransaction> findByTime(Timestamp from, Timestamp to){
        return this.motLuotNhapRepo.findByTime(from, to);
    }    
}
