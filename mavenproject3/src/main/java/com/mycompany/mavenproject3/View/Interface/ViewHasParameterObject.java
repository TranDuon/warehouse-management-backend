/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject3.View.Interface;

/**
 *
 * @author azoom
 */
public interface ViewHasParameterObject <T> {
    public T getParameterFromView();
    
    public void setParameterAndReload(T t);
    
    public void reloadParameterOnView();
}
