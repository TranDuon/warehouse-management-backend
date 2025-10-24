/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.RolesOfUser;

import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;
import java.util.List;


/**
 *
 * @author azoom
 */
public class RolesOfUserService 
        implements ServiceInterface<RolesOfUser, RolesOfUserId>
{
    private RolesOfUserRepo rolesOfUserRepo;

    public RolesOfUserService() {
        this.rolesOfUserRepo = new RolesOfUserRepo();
    }

    @Override
    public RolesOfUser findById(RolesOfUserId id) {
        return this.rolesOfUserRepo.findById(id);
    }

    @Override
    public List<RolesOfUser> getList(Integer sttPage, Integer sizePage) {
        return this.rolesOfUserRepo.getList(sttPage, sizePage);
    }

    @Override
    public RolesOfUser create(RolesOfUser t) {
        return this.rolesOfUserRepo.create(t);
    }
    
    @Override
    public RolesOfUser update(RolesOfUserId id, RolesOfUser t) {
        t.setId(id);
        return this.rolesOfUserRepo.update(id, t);
    }

    @Override
    public Boolean delete(RolesOfUserId id) {
        return this.rolesOfUserRepo.delete(id);
    }

    public List<RolesOfUser> findByUserid(Long userId){
        return this.rolesOfUserRepo.findByUserid(userId);
    }
}
