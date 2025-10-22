/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.User;

import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;

/**
 *
 * @author azoom
 */
public class UserService 
        implements ServiceInterface<User, Long>
{
    private final UserRepo userRepo;

    public UserService() {
        this.userRepo = new UserRepo();
    }

    
    
    @Override
    public User findById(Long id) {
        return this.userRepo.findById(id);
    }

    @Override
    public List<User> getList(Integer sttPage, Integer sizePage) {
        return this.userRepo.getList(sttPage, sizePage);
    }
    @Override

    public User create(User t) {
        return this.userRepo.create(t);
    }

    @Override
    public User update(Long id, User t) {
        return this.userRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.userRepo.delete(id);
    }

    public User findByUsername(String username){
        return this.userRepo.findByUsername(username);
    }

    public User findByUsernamePassword(UserDto userDto){
        return this.userRepo.findByUsernamePassword(userDto);
    }
}
