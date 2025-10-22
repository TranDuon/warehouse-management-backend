/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.Db.Interface;

import java.util.List;

/**
 *
 * @author azoom
 * @param <T>
 * @param <Id>
 */
public interface ServiceInterface <T, Id> {
    
    public T findById(Id id);

    public List<T> getList(Integer sttPage, Integer sizePage);

    public T create(T t);

    public T update(Id id, T t);

    public Boolean delete(Id id);

}
