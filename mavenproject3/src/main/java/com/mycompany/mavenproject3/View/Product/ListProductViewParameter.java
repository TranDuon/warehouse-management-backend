/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.VatPham;

/**
 *
 * @author azoom
 */
public class ListVatPhamViewParameter {
    private Integer sttPage;
    private Integer sizePage;

    public ListVatPhamViewParameter() {
    }

    public ListVatPhamViewParameter(Integer sttPage, Integer sizePage) {
        this.sttPage = sttPage;
        this.sizePage = sizePage;
    }

    public Integer getSttPage() {
        return sttPage;
    }

    public void setSttPage(Integer sttPage) {
        this.sttPage = sttPage;
    }

    public Integer getSizePage() {
        return sizePage;
    }

    public void setSizePage(Integer sizePage) {
        this.sizePage = sizePage;
    }
    
    
}
