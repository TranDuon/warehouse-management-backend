/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.Interface;

/**
 *
 * @author azoom
 */
public interface ViewHasObjectInterface <T> 
        extends ViewInterface
{
    public void setObjectAndReload(T t);
    
    public T getObjectFromView();
    
    public void reloadObjectOnView();
}
