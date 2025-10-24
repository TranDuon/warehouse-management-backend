/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.View.Interface;

import java.util.List;

/**
 *
 * @author azoom
 */
public interface ViewHasListObjectInterface <T> 
        extends ViewInterface
{
    public void setListObjectAndReload(List<T> dsT);
    
    public List<T> getListObjectFromView();
    
    public void reloadListObjectOnView();
}
