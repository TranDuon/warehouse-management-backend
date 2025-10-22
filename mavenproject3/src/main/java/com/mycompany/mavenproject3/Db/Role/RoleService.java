/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.Role;

import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;
import java.util.List;



/**
 *
 * @author azoom
 */
public class RoleService 
        implements ServiceInterface<Role, Long>
{
    private RoleRepo roleRepo;

    public RoleService() {
        this.roleRepo = new RoleRepo();
    }
    
    

    @Override
    public Role findById(Long id) {
        return this.roleRepo.findById(id);
    }

    @Override
    public List<Role> getList(Integer sttPage, Integer sizePage) {
        return this.roleRepo.getList(sttPage, sizePage);
    }
    @Override

    public Role create(Role t) {
        return this.roleRepo.create(t);
    }

    @Override
    public Role update(Long id, Role t) {
        return this.roleRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.roleRepo.delete(id);
    }

    public Role findByName(String name){
        return this.roleRepo.findByName(name);
    }
}
